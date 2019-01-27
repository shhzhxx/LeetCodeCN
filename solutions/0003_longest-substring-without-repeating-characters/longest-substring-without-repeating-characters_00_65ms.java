class Solution {
    public int lengthOfLongestSubstring(String s) {
        // åå¼å§æ³çä¹æ¯æ»å¨çªå£æ³ï¼ä½æ¯æ²¡æ³å°è¦ç¨HashSetå å¿«éåº¦ï¼æç¶å¯¹ä¸äºå¸¸ç¨çæ°æ®ç»æè¿æ¯ä¸å¤ªçæ
        if (s.length() < 1)
            return 0;
        else if (s.length() == 1)
            return 1;

        Set<Character> window = new HashSet<>();
        int i = 0, j = 0, maxLen = 0, curLen = 0;

        while (j < s.length()) {
            if (!window.contains(s.charAt(j))) {
                window.add(s.charAt(j));
                ++j;
                ++curLen;
                maxLen = maxLen > curLen ? maxLen : curLen;
            } else {
                while (window.contains(s.charAt(j))) {
                    window.remove(s.charAt(i));
                    ++i;
                    --curLen;
                }
            }
        }

        return maxLen;
    }
}