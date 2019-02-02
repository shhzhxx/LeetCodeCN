class Solution {
    public String removeDuplicateLetters(String s) {
        // æç»ç»ææå¤å«æ26ä¸ªå­æ¯ï¼å æ­¤æä»¬å¯ä»¥ä½¿ç¨ä¸ä¸ªcharæ°ç»ä¿å­ç»æï¼åæ¶ç¨ä¸ä¸ªbooleanæ°ç»è®°å½å­ç¬¦æ¯å¦å·²å å¥ç»æ
        StringBuilder sb = new StringBuilder();
        boolean[] isExist = new boolean[26];
        char[] res = new char[26];
        int resIndex = 0;

        for(int i = 0;i < s.length();++i){
            char curChar = s.charAt(i);

            // å¦æç»æåå«è¿ä¸ªå­ç¬¦ï¼åè·³è¿
            if(isExist[curChar - 'a'])
                continue;

            // æ£æ¥ç°æç»ææ¯å¦å¯ä»¥è¢«ä¼å
            for(int j = resIndex - 1;j >= 0;--j){
                char tmpChar = res[j];

                // å¦ææä¸ä¸ªå­ç¬¦å­å¸åºæ¯å½åå­ç¬¦å¤§ï¼å¹¶ä¸åé¢è¿ä¸ªå­ç¬¦è¿åºç°è¿ï¼åææ¶ä»ç»æä¸­å°å¶å å»
                if(tmpChar > curChar && s.substring(i).contains(String.valueOf(tmpChar))){
                    resIndex = j;
                    isExist[tmpChar - 'a'] = false;
                    continue;
                }
                break;
            }
            // å°å½åå­ç¬¦æ¾å¨ææ¶åéçå°æ¹
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