class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        // 中心扩展算法
        int start = 0, end = 0, len_odd, len_even;

        for (int i = 0; i < s.length(); ++i) {
            int tmp_len;
            len_odd = getLongestPalindrome(s, i, i);
            len_even = getLongestPalindrome(s, i, i + 1);
            tmp_len = len_odd > len_even ? len_odd : len_even;
            if (tmp_len > end - start) {
                start = i - (tmp_len - 1) / 2;
                end = i + tmp_len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // 中心扩展算法
    private int getLongestPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            --left;
            ++right;
        }
        return right - left - 1;
    }
}