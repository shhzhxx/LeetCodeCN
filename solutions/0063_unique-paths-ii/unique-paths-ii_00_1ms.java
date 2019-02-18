class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] tmp = new int[n], res = new int[n];

        res[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < n; ++i)
            res[i] = obstacleGrid[0][i] == 1 ? 0 : res[i - 1];

        while (--m != 0) {
            tmp[0] = obstacleGrid[obstacleGrid.length - m][0] == 1 ? 0 : res[0];

            for (int i = 1; i < n; ++i)
                tmp[i] = obstacleGrid[obstacleGrid.length - m][i] == 1? 0 : (tmp[i - 1] + res[i]);
            
            res = Arrays.copyOf(tmp, n);
        }

        return res[n - 1];
    }
}