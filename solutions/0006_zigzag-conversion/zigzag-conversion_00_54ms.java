class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        char[] chs = new char[s.length()];
        int seg = numRows + numRows - 2, index = -1;

        for (int base = 0; base < numRows; ++base) {
            for (int i = base; i < s.length(); i += seg) {
                chs[++index] = s.charAt(i);
                if (base != 0 && base != numRows - 1) {
                    int tmp = i + seg - base - base;
                    if (tmp < s.length()) {
                        chs[++index] = s.charAt(tmp);
                    }
                }
            }
        }

        return new String(chs);
    }
}