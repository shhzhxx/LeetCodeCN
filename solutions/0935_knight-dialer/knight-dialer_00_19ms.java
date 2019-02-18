class Solution {
    public int knightDialer(int N) {
        // ��̬�滮������һ���ֽ�β�ĳ���ΪN�ĺ������Ϊ�Կ���������һ���ֵ����ֽ�β�ĳ���ΪN-1�ĺ���
        // ����5���������ֲ�ͬ����N����1ʱ����������5��β�ĺ�������������Ҫ�ǵý����Ҫ����5�������
        // ע�ʹ���Ϊԭʼ���룬δע�ʹ���Ϊ��15ms�Ĵ������ﳭ���ļ�״̬��Ĵ���
        if (N == 1)
            return 10;
        long a = 1;// 0
        long b = 4;// 1��3��7��9
        long c = 2;// 2��8
        long d = 2;// 4��6

        while (--N != 0) {
            long next_a = d;
            long next_b = c + c + d + d;
            long next_c = b;
            long next_d = a + a + b;
            a = next_a % 1000000007;
            b = next_b % 1000000007;
            c = next_c % 1000000007;
            d = next_d % 1000000007;
        }

        return (int) ((a + b + c + d) % 1000000007);
//        if (N == 1)
//            return 10;
//        long[] tmp = new long[10], res;
//        long sum = 0;
//        for (int i = 0; i < 10; ++i)
//            tmp[i] = 1;
//
//        res = Arrays.copyOf(tmp, 10);
//        while (--N != 0) {
//            tmp[0] = (res[4] + res[6]) % 1000000007;
//            tmp[1] = (res[6] + res[8]) % 1000000007;
//            tmp[2] = (res[7] + res[9]) % 1000000007;
//            tmp[3] = (res[4] + res[8]) % 1000000007;
//            tmp[4] = (res[0] + res[3] + res[9]) % 1000000007;
//            tmp[6] = (res[0] + res[1] + res[7]) % 1000000007;
//            tmp[7] = (res[2] + res[6]) % 1000000007;
//            tmp[8] = (res[1] + res[3]) % 1000000007;
//            tmp[9] = (res[2] + res[4]) % 1000000007;
//            res = Arrays.copyOf(tmp, 10);
//        }
//
//        for (long total : res)
//            sum += total;
//
//        return (int) ((sum - 1) % 1000000007);
    }
}