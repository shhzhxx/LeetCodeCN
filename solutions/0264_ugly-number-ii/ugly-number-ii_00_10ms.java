class Solution {
    public int nthUglyNumber(int n) {
        int u2 = 0, u3 = 0, u5 = 0;
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; ++i) {
            int t2 = res[u2] * 2;
            int t3 = res[u3] * 3;
            int t5 = res[u5] * 5;
            int tmp = t2 < t3 ? t2 : t3;
            res[i] = tmp < t5 ? tmp : t5;
            if (res[i] == t2) ++u2;
            if (res[i] == t3) ++u3;
            if (res[i] == t5) ++u5;
        }

        return res[n - 1];
    }
}