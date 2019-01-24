class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int row = m, col = n;
        for(int[] op: ops){
            row = Integer.min(row, op[0]);
            col = Integer.min(col, op[1]);
        }

        return row * col;
    }
}