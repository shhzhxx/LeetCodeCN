class Solution {
    public int minSwap(int[] A, int[] B) {
        // 动态规划，记录交换和不交换当前元素的最小次数
        // 每处理一个下标，会遇到三种情况：必须交换、可以交换和不可以交换。
        int doSwap = 1, noSwap = 0;

        for (int i = 1; i < A.length; ++i) {
            if (A[i - 1] >= B[i] || B[i - 1] >= A[i]) {
                // 不可以交换
                ++doSwap;
            } else if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
                // 必须交换
                int tmp = noSwap + 1;
                noSwap = doSwap;
                doSwap = tmp;
            } else {
                // 都可以
                int tmp = doSwap < noSwap ? doSwap : noSwap;
                doSwap = tmp + 1;
                noSwap = tmp;
            }
        }

        return doSwap < noSwap ? doSwap : noSwap;
    }
}