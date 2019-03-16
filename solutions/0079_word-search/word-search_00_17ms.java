class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if(row < 1)
            return false;
        int col = board[0].length;
        if(row * col < word.length())
            return false;
        
        for(int i = 0;i < row;++i)
            for(int j = 0;j < col;++j)
                if(core(board, word, i, j, 0))
                    return true;
        return false;
    }
    
    private boolean core(char[][] board, String word, int curRow, int curCol, int index){
        if(index == word.length())
            return true;
        
        
        int row = board.length;
        int col = board[0].length;
        
        if(curRow < 0 || curCol < 0 || curRow == row || curCol == col)
            return false;
        
        if(board[curRow][curCol] == '/')
            return false;
        
        if(word.charAt(index) != board[curRow][curCol])
            return false;
        
        char ch = word.charAt(index);
        board[curRow][curCol] = '/';
        
        boolean res = core(board, word, curRow, curCol + 1, index + 1)
            || core(board, word, curRow, curCol - 1, index + 1)
            || core(board, word, curRow + 1, curCol, index + 1)
            || core(board, word, curRow - 1, curCol, index + 1);
        
        
        board[curRow][curCol] = ch;
        
        return res;
    }
}