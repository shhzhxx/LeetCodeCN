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

        // 第二个值指是否含A
        // 第三个值指末尾含几个L
        for(int i = 2;i < n + 1;++i){
            long t00 = res[0][0];
            long t01 = res[0][1];
            long t02 = res[0][2];
            long t10 = res[1][0];
            long t11 = res[1][1];
            // 末尾0个L，串中无A  *P*
            res[0][0] = (t00 + t01 + t02) % max;
            // 末尾1个L，串中无A  *L*
            res[0][1] = t00;
            // 末尾2个L，串中无A  *L*
            res[0][2] = t01;
            // 末尾0个L，串中有A  *A、P*
            res[1][0] = (res[0][0] + res[1][0] + res[1][1] + res[1][2]) % max;
            // 末尾1个L，串中有A  *L*
            res[1][1] = t10;
            // 末尾2个L，串中有A  *L*
            res[1][2] = t11;
        }

        return (int) ((res[0][0] + res[0][1] + res[0][2] + res[1][0] + res[1][1] + res[1][2]) % max);
    }
}