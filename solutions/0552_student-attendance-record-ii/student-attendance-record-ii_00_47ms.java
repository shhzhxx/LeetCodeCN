class Solution {
    public int checkRecord(int n) {
        if(n == 0)
            return 0;

        long[][] res = new long[2][3];
        res[0][0] = 1;  // P
        res[0][1] = 1;  // L
        res[0][2] = 0;
        res[1][0] = 1;  // A
        res[1][1] = 0;
        res[1][2] = 0;

        long max = 1000000007;

        // �ڶ���ֵָ�Ƿ�A
        // ������ֵָĩβ������L
        for(int i = 2;i < n + 1;++i){
            long t00 = res[0][0];
            long t01 = res[0][1];
            long t02 = res[0][2];
            long t10 = res[1][0];
            long t11 = res[1][1];
            // ĩβ0��L��������A  *P*
            res[0][0] = (t00 + t01 + t02) % max;
            // ĩβ1��L��������A  *L*
            res[0][1] = t00;
            // ĩβ2��L��������A  *L*
            res[0][2] = t01;
            // ĩβ0��L��������A  *A��P*
            res[1][0] = (res[0][0] + res[1][0] + res[1][1] + res[1][2]) % max;
            // ĩβ1��L��������A  *L*
            res[1][1] = t10;
            // ĩβ2��L��������A  *L*
            res[1][2] = t11;
        }

        return (int) ((res[0][0] + res[0][1] + res[0][2] + res[1][0] + res[1][1] + res[1][2]) % max);
    }
}