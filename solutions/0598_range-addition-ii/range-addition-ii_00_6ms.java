class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int row = m, col = n;
        for(int[] op: ops){
            row = row < op[0] ? row : op[0];
            col = col < op[1] ? col : op[1];
        }

        return row * col;
    }
}