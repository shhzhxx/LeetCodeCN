class Solution {
    public int divide(int dividend, int divisor) {
        // ��λ���������ѭ����ÿ���ҵ�����n(2^n <= dividend)��������dividend��ɾȥ��һ����
        int res = 0;
        boolean isPositive = dividend > 0 ^ divisor < 0;

        // ����Ҫע�⣬Ҫ����divisorת����ʱ���
        if(divisor == -2147483648)
            return dividend == -2147483648 ? 1 : 0;

        divisor = Math.abs(divisor);

        // ����Ҫע�⣬Ҫ����dividendת����ʱ���
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

                // ����Ҫע�⣬�ж�����tmp < tmp << 1��Ϊ�˱���tmp���
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