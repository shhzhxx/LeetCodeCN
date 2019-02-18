class Solution {
    public int minFallingPathSum(int[][] A) {
        int maxVal = Integer.MAX_VALUE, minSum = maxVal;
        int len = A[0].length;
        int[] oldRecord = Arrays.copyOf(A[0], len);
        int[] newRecord = new int[len];

        for (int i = 1; i < A.length; ++i) {
            for (int j = 0; j < len; ++j) {
                int t_left = maxVal, t_mid = oldRecord[j], t_right = maxVal;
                if (j - 1 >= 0)
                    t_left = oldRecord[j - 1];
                if (j + 1 < len)
                    t_right = oldRecord[j + 1];
                newRecord[j] = A[i][j] + minTri(t_left, t_mid, t_right);
            }
            oldRecord = Arrays.copyOf(newRecord, len);
        }

        for (int sum : oldRecord)
            minSum = minSum < sum ? minSum : sum;

        return minSum;
    }

    private int minTri(int t1, int t2, int t3) {
        if (t1 < t2)
            return t1 < t3 ? t1 : t3;
        else
            return t2 < t3 ? t2 : t3;
    }
}