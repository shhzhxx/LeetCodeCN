class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] row;
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];
        
        for(int i = 0;i < 9;++i){
            row = new int[9];
            for(int j = 0;j < 9;++j){
                if(board[i][j] == '.')
                    continue;
                
                int cur = board[i][j] - '1';
                int curBox = i / 3 * 3 + j / 3;
                ++row[cur];
                ++col[j][cur];
                ++box[curBox][cur];
                
                if(row[cur] > 1 || col[j][cur] > 1 || box[curBox][cur] > 1)
                    return false;
            }
        }
        
        return true;
    }
}