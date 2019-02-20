class Solution {
    public int divide(int dividend, int divisor) {
        // 移位代替除法，循环中每次找到最大的n(2^n <= dividend)，保存后从dividend中删去这一部分
        int res = 0;
        boolean isPositive = dividend > 0 ^ divisor < 0;

        // 这里要注意，要避免divisor转正数时溢出
        if(divisor == -2147483648)
            return dividend == -2147483648 ? 1 : 0;

        divisor = Math.abs(divisor);

        // 这里要注意，要避免dividend转正数时溢出
        if(dividend == -2147483648)
            if(divisor == 1)
                return isPositive ? 2147483647 : -2147483648;
            else{
                res = 1;
                dividend += divisor;
            }

        dividend = Math.abs(dividend);

        if(divisor == 1)
            res = dividend;
        else {
            while(divisor <= dividend){
                int cnt = 1, tmp = divisor;

                // 这里要注意，判断条件tmp < tmp << 1是为了避免tmp溢出
                while(tmp <= dividend && tmp < tmp << 1){
                    tmp <<= 1;
                    cnt <<= 1;
                }

                res += cnt > 1 ? cnt >> 1 : cnt;
                dividend -= cnt > 1 ? tmp >> 1 : tmp;
            }
        }

        return isPositive ? res : 0 - res;
    }
}