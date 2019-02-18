class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row, col;
        for(int i = 0;i < matrix.length;++i)
            for(int j = 0;j < matrix[i].length;++j){
                row = i + 1;
                col = j + 1;
                if(row < matrix.length && col < matrix[i].length)
                    if(matrix[i][j] != matrix[row][col])
                        return false;
            }
        return true;
    }
}