class Solution {
    public String multiply(String num1, String num2) {
        // 保证num1是数位较少的那一个
        if (num1.length() > num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        if(num1.equals("0"))
            return "0";

        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();
        int totalLen = chs1.length + chs2.length;

        StringBuilder res = new StringBuilder();
        int carry = 0, curUnit = 0;

        while(carry != 0 || curUnit < totalLen - 1) {
            // sum包括了上一次的进位
            int sum = carry;
            int start = chs1.length - 1 - curUnit;
            start = start > 0 ? start : 0;
            for (int i = start, j = totalLen - 2 - curUnit - i; j >= 0 && i < chs1.length; ++i, j = totalLen - 2 - curUnit - i) {
                sum += (chs1[i] - '0') * (chs2[j] - '0');
            }

            if (sum > 9) {
                res.insert(0, (char) (sum % 10 + '0'));
                carry = sum / 10;
            } else {
                res.insert(0, (char) (sum + '0'));
                carry = 0;
            }

            ++curUnit;
        }
        return new String(res);
    }
}