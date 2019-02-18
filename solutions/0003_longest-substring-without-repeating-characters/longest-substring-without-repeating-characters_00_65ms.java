class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 刚开始想的也是滑动窗口法，但是没想到要用HashSet加快速度，果然对一些常用的数据结构还是不太熟悉
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