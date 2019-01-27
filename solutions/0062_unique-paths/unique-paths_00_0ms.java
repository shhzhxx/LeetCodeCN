class Solution {
    public int uniquePaths(int m, int n) {
        int[] tmp = new int[n], res = new int[n];
        for (int i = 0; i < n; ++i)
            res[i] = 1;

        while (--m != 0) {
            tmp[0] = res[0];
            for (int i = 1; i < n; ++i)
                tmp[i] = tmp[i - 1] + res[i];
            res = Arrays.copyOf(tmp, n);
        }

        return res[n - 1];
    }
}