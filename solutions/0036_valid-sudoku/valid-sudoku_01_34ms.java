class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];
        
        for(int i = 0;i < 9;++i)
            for(int j = 0;j < 9;++j){
                if(board[i][j] == '.')
                    continue;
                
                int cur = board[i][j] - '1';
                int curBox = i / 3 * 3 + j / 3;
                ++row[i][cur];
                ++col[j][cur];
                ++box[curBox][cur];
                
                if(row[i][cur] > 1 || col[j][cur] > 1 || box[curBox][cur] > 1)
                    return false;
            }
        
        return true;
    }
}