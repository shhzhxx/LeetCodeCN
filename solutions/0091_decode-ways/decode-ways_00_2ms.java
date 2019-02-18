class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
        if (s.charAt(0) == '0')
            return 0;
        if (s.length() == 1)
            return s.equals("0") ? 0 : 1;
        int last_2 = 1, last_1 = s.charAt(0) == '0' ? 0 : 1, res = 0;

        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                if (validTwoChar(s.charAt(i - 1), s.charAt(i)))
                    res = last_2;
                else
                    return 0;
            } else {
                if (s.charAt(i - 1) == '0')
                    res = last_1;
                else if (!validTwoChar(s.charAt(i - 1), s.charAt(i)))
                    res = last_1;
                else
                    res = last_1 + last_2;
            }
            last_2 = last_1;
            last_1 = res;
        }

        return res;
    }

    private boolean validTwoChar(char high, char low) {
        if (high == '1')
            return true;
        else
            return high == '2' && low <= '6' && low >= '0';
    }
}