class Solution {
    public int reverse(int x) {
        boolean isPos = true;
        char[] chs = String.valueOf(x).toCharArray();
        long res = 0;
        int end = 0;
        if(chs[0] == '-') {
            isPos = false;
            end = 1;
        }

        for(int i = chs.length - 1;i >= end;--i){
            res = res * 10 + (chs[i] - '0');
        }

        if(isPos)
            return res > Integer.MAX_VALUE ? 0 : (int) res;
        else {
            res = 0 - res;
            return res < Integer.MIN_VALUE ? 0 : (int) res;
        }
    }
}