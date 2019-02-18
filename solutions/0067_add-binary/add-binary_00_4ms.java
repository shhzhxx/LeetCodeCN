class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length(), lenB = b.length();
        int iA = lenA, iB = lenB;
        int carry = 0;
        StringBuilder sb = new StringBuilder(1 + (lenA > lenB ? lenA : lenB));

        while (iA > 0 || iB > 0 || carry != 0) {
            --iA;
            --iB;
            int curA = iA >= 0 ? a.charAt(iA) - '0' : 0;
            int curB = iB >= 0 ? b.charAt(iB) - '0' : 0;
            int res = curA + curB + carry;

            switch (res) {
                case 0:
                    carry = 0;
                    sb.insert(0, '0');
                    break;
                case 1:
                    carry = 0;
                    sb.insert(0, '1');
                    break;
                case 2:
                    carry = 1;
                    sb.insert(0, '0');
                    break;
                case 3:
                    carry = 1;
                    sb.insert(0, '1');
                    break;
                default:
            }
        }

        return new String(sb);
    }
}