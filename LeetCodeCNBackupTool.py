import time
import configparser
import requests
import os
import re
import pprint
import json
from urllib import parse

CWD = os.getcwd()
REPO = ''
COOKIE_FILE_NAME = 'cookies.json'
HOST_URL = "https://leetcode-cn.com"
ARTICLE_URL = 'https://leetcode-cn.com/articles'
PROBLEM_URL = 'https://leetcode-cn.com/problems'
LOGIN_URL = "/accounts/login/"
PROGRESS_API = "/api/progress/all/"
PROBLEM_API = "/api/problems/all/"

CODE_PATTERN = re.compile(r'submissionCode: \'(.*)\',\n\s*editCodeUrl')
NAME_PATTERN = re.compile(r'href="/problems/(.*)/">')

FILE_EXT = {
    'java': '.java',
    'cpp': '.cpp',
    'python': '.py',
    'python3': '.py',
    'c': '.c',
    'csharp': '.cs',
    'javascript': '.js',
    'ruby': '.rb',
    'kotlin': '.kt',
    'swift': '.swift',
    'golang': '.go',
    'scala': '.scala',
    'rust': '.rs'
}

HEADERS = {
    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8',
    'Accept-Encoding': 'gzip, deflate, br',
    'Accept-Language': 'zh-CN,zh;q=0.9',
    'Connection': 'keep-alive',
    'Host': 'leetcode-cn.com',
    'Referer': 'https://leetcode-cn.com/accounts/login/',
    'Upgrade-Insecure-Requests': '1',
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36'
}


class Account:
    __config_file_name = "config.cfg"

    __session = None
    # __config['LPSI'] means 'last_preserved_submission_id'
    __config = None
    __cookie = None

    def __init__(self):
        self.__config = self.__get_config()
        self.__cookie = dict()
        # print(self.__config)
        self.__session = requests.session()
        self.__session.headers.update(HEADERS)

    def __get_config(self):
        '''
        从配置文件中获取配置config，config是一个包含用于登陆网站的字段'usr'、'pwd'和用于配置selenium的字段'driverPath'的dict
        配置文件在工作目录下，若不存在或任意一项配置为空，则会调用self.__create_cfg()方法生成文件并抛出异常
        :return: config
        '''
        global REPO
        config = dict()
        cp = configparser.ConfigParser()
        cp.read(os.path.join(CWD, self.__config_file_name))
        if 'leetcode' not in list(cp.sections()):
            self.__create_cfg()
            raise Exception('please ensure that you set the .cfg file correctly.')
        try:
            config['usr'] = cp.get('leetcode', 'userName')
            config['pwd'] = cp.get('leetcode', 'password')
            config['repo'] = cp.get('leetcode', 'repo')
            config['LPSI'] = cp.get('leetcode', 'LPSI')
        except configparser.NoOptionError:
            self.__create_cfg()
            raise Exception('the .cfg file is corrupt. Please fill it again.')
        if not config['usr'] or not config['pwd'] or not config['repo']:
            raise Exception('the .cfg file should be filled.')
        REPO = config['repo']
        return config

    def __create_cfg(self):
        config = configparser.ConfigParser()
        config['leetcode'] = {"userName": "",
                              "password": "",
                              "repo": "",
                              "LPSI": ""}

        with open(os.path.join(CWD, self.__config_file_name), 'w', encoding='utf-8') as configFile:
            config.write(configFile)

    def is_login(self):
        url = HOST_URL + PROGRESS_API
        cookie_file = os.path.join(CWD, COOKIE_FILE_NAME)
        if not os.path.exists(cookie_file):
            return False

        with open(cookie_file, 'r', encoding='utf-8') as f:
            old_cookies = json.load(f)

        # print(old_cookies)
        self.__cookie = old_cookies
        self.__session.cookies.update(self.__cookie)
        r = self.__session.get(url)
        time.sleep(5)

        # print(r.text)
        if r.status_code != 200 or 'solvedPerDifficulty' not in r.json():
            return False
        else:
            return True

    def login(self):
        url = HOST_URL + LOGIN_URL
        cookie_path = os.path.join(CWD, COOKIE_FILE_NAME)

        res = self.__session.get(url=url, headers=HEADERS)
        time.sleep(5)
        assert res.status_code == 200

        login_data = dict()
        login_data['login'] = self.__config['usr']
        login_data['password'] = self.__config['pwd']
        login_data['csrfmiddlewaretoken'] = res.cookies['csrftoken']
        # pprint.pprint(login_data)

        res = self.__session.post(url=url, headers=HEADERS, data=login_data)
        assert res.status_code == 200

        self.__cookie = requests.utils.dict_from_cookiejar(self.__session.cookies)
        # print(self.__cookie)
        with open(cookie_path, 'w', encoding='utf-8') as f:
            json.dump(self.__cookie, f, indent=2)

        if 'LEETCODE_SESSION' not in self.__cookie:
            raise Exception('fail to login. Please check upon the .cfg file.')

        return self.__session

    def get_session(self):
        return self.__session
    
    def get_last_preserved_sub_id(self):
        return self.__config['LPSI']
    
    def write_last_preserved_sub_id(self, LPSI):
        cp = configparser.ConfigParser()
        cp_path = os.path.join(CWD, self.__config_file_name)
        cp.read(cp_path)
        cp.set('leetcode', 'LPSI', str(LPSI))
        with open(cp_path, 'w', encoding='utf-8') as configFile:
            cp.write(configFile)


class Archive:
    __account = None
    __ac_easy = 0
    __ac_medium = 0
    __ac_hard = 0
    __num_solved = 0
    __num_total = 0
    __user_name = ""
    __problems = None
    __ac_records = None
    __name_to_id_dict = None
    __LPSI = None

    __session = None

    def __init__(self, account):
        self.__account = account
        if account.is_login():
            self.__session = account.get_session()
            print('拿之前的旧cookie登陆成功了.')
        else:
            self.__session = account.login()
            print('重新登陆.')
        self.__problems = dict()
        self.__ac_records = dict()
        self.__name_to_id_dict = dict()
        self.__LPSI = account.get_last_preserved_sub_id()

    def run(self):
        self.__get_general_info_and_stat_status_pairs()
        self.__write_general_info()
        self.__write_stat_status_pairs()
        self.__get_submission_history()
        self.__write_submissions()
        self.__session.close()

    def __get_general_info_and_stat_status_pairs(self):
        session = self.__session
        url = HOST_URL + PROBLEM_API
        # print(url)
        # pprint.pprint(session.cookies)
        r = session.get(url)
        time.sleep(5)

        # print(r.status_code)
        assert r.status_code == 200

        data = r.json()
        self.__ac_easy = data['ac_easy']
        self.__ac_medium = data['ac_medium']
        self.__ac_hard = data['ac_hard']
        self.__num_solved = data['num_solved']
        self.__num_total = data['num_total']
        self.__user_name = data['user_name']
        self.__get_stat_status_pairs(data['stat_status_pairs'])
        print('获取刷题的进度.')

    def __write_general_info(self):
        md_path = os.path.join(CWD, 'README.md')
        md_head = '''## My LeetCode Solution Archive

**Update Time:** {update_time}

> Based on [bonfy's work](https://github.com/bonfy/leetcode)

- [x] 自动更新README文档
- [x] 下载所有Ac的代码
- [x] 增量更新
- [ ] 代码优化

**注意:**
1. 在 config.cfg 文件中填写登录信息和GitHub库地址
2. lpsi字段会自动填写，如需重新下载所有Ac代码，请清空lpsi字段
3. 由于保存了敏感信息，请勿上传 config.cfg 和 cookies.json 这两个文件
4. 代码非常紊乱，目前处于能用就行的状态，优化工作无限期延后

||SOLVED||
|:-:|:-:|:-:|
|<font color=#5CB85C>Easy</font>|<font color=#F0AD4E>Medium</font>|<font color=#D9534F>Hard</font>|
|{ac_easy}|{ac_medium}|{ac_hard}|

**Total Progress:** {num_solved} / {num_total}

|ID|Title|Solution|Article|Difficulty|
|:-:|:-:|:-:|:-:|:-:|\n'''.format(update_time=time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()),
                                  ac_easy=self.__ac_easy,
                                  ac_medium=self.__ac_medium,
                                  ac_hard=self.__ac_hard,
                                  num_solved=self.__num_solved,
                                  num_total=self.__num_total)
        with open(md_path, 'w', encoding='utf-8') as md_file:
            md_file.write(md_head)

    def __get_stat_status_pairs(self, pairs):
        '''
        获取所有问题的状态信息，不包括代码和题目内容，顺便填充根据名字寻找问题id的字典
        :param pairs:json格式
        :return:
        '''
        for problem in pairs:
            if problem['stat']['question__hide']:
                continue
            self.__name_to_id_dict[problem['stat']['question__title_slug']] = problem['stat']['frontend_question_id']
            p_data = dict()
            p_data['question__title_slug'] = problem['stat']['question__title_slug']
            p_data['frontend_question_id'] = problem['stat']['frontend_question_id']
            p_data['question__article__slug'] = problem['stat']['question__article__slug']
            p_data['difficulty'] = problem['difficulty']['level']
            p_data['paid_only'] = problem['paid_only']
            p_data['ac_status'] = True if problem['status'] == 'ac' else False
            self.__problems[p_data['frontend_question_id']] = p_data

    def __write_stat_status_pairs(self):
        '''
        将题目的状态信息保存到首页的README.md中
        :return:
        '''
        md_path = os.path.join(CWD, 'README.md')
        with open(md_path, 'a', encoding='utf-8') as md_file:
            for key in sorted(self.__problems.keys()):
                problem = self.__problems[key]
                problem_id = str(problem['frontend_question_id']).zfill(4)
                question_url = PROBLEM_URL + '/' + problem['question__title_slug']

                if problem['ac_status']:
                    solution_path = REPO + '/blob/master/solutions/'\
                                    + problem_id\
                                    + '_'\
                                    + problem['question__title_slug']\
                                    + '/'
                    solution = '[:bulb:](' + solution_path + ')'
                elif problem['paid_only']:
                    solution = ':moneybag:'
                else:
                    solution = ''

                if problem['question__article__slug']:
                    article = '[:book:]' + '(' + ARTICLE_URL + '/' + problem['question__article__slug'] + ')'
                else:
                    article = ''

                content = (
                    '|{question_id}|[{question_title}]({question_url})|{solution}|{article}|{difficulty}|\n'
                ).format(question_id=problem['frontend_question_id'],
                         question_title=problem['question__title_slug'],
                         question_url=question_url,
                         solution=solution,
                         article=article,
                         difficulty=self.__get_difficulty(problem['difficulty']))
                md_file.write(content)

    def __get_difficulty(self, level):
        if level == 1:
            return '<font color=#5CB85C>Easy</font>'
        elif level == 2:
            return '<font color=#F0AD4E>Medium</font>'
        else:
            return '<font color=#D9534F>Hard</font>'

    def __get_submission_history(self):
        '''
        分析提交历史，将通过的题目记录下来
        :return:
        '''
        session = self.__session
        has_write_LPSI = False
        has_next = True
        meet_LPSI = False
        last_key = ''
        offset = 0
        limit = 20
        while has_next and not meet_LPSI:
            print('正在分析第' + str(offset) + '次提交历史')
            url = HOST_URL + "/api/submissions/?offset={}&limit={}&lastkey={}".format(offset, limit, last_key)
            r = session.get(url)
            time.sleep(5)

            assert r.status_code == 200

            data = r.json()
            if not data['has_next']:
                has_next = False
            else:
                last_key = data['last_key']
                offset += limit
                for submission in data['submissions_dump']:
                    if str(submission['id']) == self.__LPSI:
                        meet_LPSI = True
                        break
                    elif not has_write_LPSI:
                        self.__account.write_last_preserved_sub_id(submission['id'])
                        has_write_LPSI = True
                    self.__remain_right_submission(submission)

    def __remain_right_submission(self, submission):
        if submission['status_display'] == 'Accepted':
            p_data = dict()
            p_data['url'] = submission['url']
            p_data['lang'] = submission['lang']
            p_data['runtime'] = int(submission['runtime'][:-3])
            self.__ac_records[submission['id']] = p_data

    def __write_submissions(self):
        for submission_id in self.__ac_records:
            sub = self.__ac_records[submission_id]

            sub_url = HOST_URL + sub['url']
            sub_code, sub_name = self.__get_submission_code_and_name(sub_url)
            
            # 由于部分竞赛题不在题库当中，我还没有参加过竞赛，不了解其中的数据结构，所以暂时不保存
            if sub_name not in self.__name_to_id_dict:
                continue
            problem = self.__problems[self.__name_to_id_dict[sub_name]]
            str_problem_id = str(problem['frontend_question_id']).zfill(4)

            file_path = os.path.join(CWD, 'solutions', str_problem_id + '_' + sub_name)
            if not os.path.exists(file_path):
                os.makedirs(file_path)
            num_files = os.listdir(file_path)
            file_name = sub_name + '_' + str(len(num_files)).zfill(2) + '_' + str(sub['runtime']) + 'ms' + FILE_EXT[sub['lang']]

            with open(os.path.join(file_path, file_name), 'w', encoding='utf-8') as f:
                f.write(sub_code)

    def __get_submission_code_and_name(self, sub_url):
        print('准备获取地址为' + sub_url + '的代码')
        res = self.__session.get(sub_url)
        time.sleep(5)
        assert res.status_code == 200
        res.encoding = 'utf-8'

        sub_code = CODE_PATTERN.findall(res.text)[0]
        sub_name = NAME_PATTERN.findall(res.text)[0]

        return sub_code.encode('utf-8').decode('unicode_escape'), sub_name

if __name__ == '__main__':
    account = Account()
    archive = Archive(account)
    archive.run()
    print('done')
