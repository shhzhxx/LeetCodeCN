class Solution {
    public String removeDuplicateLetters(String s) {
        // 最终结果最多含有26个字母，因此我们可以使用一个char数组保存结果，同时用一个boolean数组记录字符是否已加入结果
        StringBuilder sb = new StringBuilder();
        boolean[] isExist = new boolean[26];
        char[] res = new char[26];
        int resIndex = 0;

        for(int i = 0;i < s.length();++i){
            char curChar = s.charAt(i);

            // 如果结果包含这个字符，则跳过
            if(isExist[curChar - 'a'])
                continue;

            // 检查现有结果是否可以被优化
            for(int j = resIndex - 1;j >= 0;--j){
                char tmpChar = res[j];

                // 如果有一个字符字典序比当前字符大，并且后面这个字符还出现过，则暂时从结果中将其删去
                if(tmpChar > curChar && s.substring(i).contains(String.valueOf(tmpChar))){
                    resIndex = j;
                    isExist[tmpChar - 'a'] = false;
                    continue;
                }
                break;
            }
            // 将当前字符放在暂时合适的地方
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