class Solution {
    public int[] plusOne(int[] digits) {
        int ptr = digits.length, carry = 0;
        do {
            --ptr;
            ++digits[ptr];
            carry = 0;
            if (digits[ptr] > 9) {
                digits[ptr] -= 10;
                carry = 1;
            }
        } while (ptr > 0 && carry != 0);

        if (carry == 0)
            return digits;
        else {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 0; i < digits.length; ++i)
                res[i + 1] = digits[i];

            return res;
        }
    }
}