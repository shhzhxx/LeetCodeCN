class Solution {

    public int myAtoi(String str) {
        long res = 0;
        int ptr = 0;
        boolean isPositive;
        char[] chs = str.toCharArray();

        while (ptr < chs.length && chs[ptr] == ' ') ++ptr;

        if (!(ptr < chs.length)) {
            return 0;
        } else if ('/' < chs[ptr] && chs[ptr] < ':') {
            isPositive = true;
        } else if (chs[ptr] == '+') {
            ++ptr;
            isPositive = true;
        } else if (chs[ptr] == '-') {
            ++ptr;
            isPositive = false;
        }
        else
            return 0;


        if(isPositive){
            while (ptr < chs.length && '/' < chs[ptr] && chs[ptr] < ':') {
                res = res * 10 + (chs[ptr] - '0');
                ++ptr;
                if(res > Integer.MAX_VALUE) {
                    res = Integer.MAX_VALUE;
                    break;
                }
            }
        }else {
            while (ptr < chs.length && '/' < chs[ptr] && chs[ptr] < ':') {
                res = res * 10 - (chs[ptr] - '0');
                ++ptr;
                if(res < Integer.MIN_VALUE){
                    res = Integer.MIN_VALUE;
                    break;
                }
            }
        }

        return (int) res;
    }
    
}