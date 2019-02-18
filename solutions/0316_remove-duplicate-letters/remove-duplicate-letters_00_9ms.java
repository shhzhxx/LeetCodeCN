class Solution {
    public String removeDuplicateLetters(String s) {
        // ���ս����ຬ��26����ĸ��������ǿ���ʹ��һ��char���鱣������ͬʱ��һ��boolean�����¼�ַ��Ƿ��Ѽ�����
        StringBuilder sb = new StringBuilder();
        boolean[] isExist = new boolean[26];
        char[] res = new char[26];
        int resIndex = 0;

        for(int i = 0;i < s.length();++i){
            char curChar = s.charAt(i);

            // ��������������ַ���������
            if(isExist[curChar - 'a'])
                continue;

            // ������н���Ƿ���Ա��Ż�
            for(int j = resIndex - 1;j >= 0;--j){
                char tmpChar = res[j];

                // �����һ���ַ��ֵ���ȵ�ǰ�ַ��󣬲��Һ�������ַ������ֹ�������ʱ�ӽ���н���ɾȥ
                if(tmpChar > curChar && s.substring(i).contains(String.valueOf(tmpChar))){
                    resIndex = j;
                    isExist[tmpChar - 'a'] = false;
                    continue;
                }
                break;
            }
            // ����ǰ�ַ�������ʱ���ʵĵط�
            res[resIndex++] = curChar;
            isExist[curChar - 'a'] = true;
        }

        for(char ch: res) {
            if (ch < 'a' || ch > 'z')
                continue;
            sb.append(ch);
        }

        return new String(sb);
    }
}