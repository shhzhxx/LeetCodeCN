class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] tmp = new int[n], res = new int[n];

        res[0] = grid[0][0];
        for (int i = 1; i < n; ++i)
            res[i] = grid[0][i] + res[i - 1];

        while (--m != 0) {
            tmp[0] = grid[grid.length - m][0] + res[0];

            for (int i = 1; i < n; ++i)
                tmp[i] = grid[grid.length - m][i] + (tmp[i - 1] < res[i] ? tmp[i - 1] : res[i]);

            res = Arrays.copyOf(tmp, n);
        }

        return res[n - 1];
    }
}