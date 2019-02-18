class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length < 1)
            return 0;

        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        int[] tmp = new int[col], res = new int[col];

        for(int i = 0;i < col;++i)
            if(matrix[0][i] == '1'){
                max = 1;
                res[i] = 1;
            }

        for(int i = 1;i < row;++i){
            tmp[0] = matrix[i][0] == '1' ? 1 : 0;
            max = tmp[0] > max ? tmp[0] : max;
            for(int j = 1;j < col;++j)
                if(matrix[i][j] == '1'){
                    int t00 = res[j - 1];
                    int t01 = res[j];
                    int t10 = tmp[j - 1];
                    int min = t00 < t01 ? t00 : t01;
                    tmp[j] = 1 + (min < t10 ? min : t10);
                    max = max > tmp[j] ? max : tmp[j];
                }else 
                    tmp[j] = 0;
            res = Arrays.copyOf(tmp, res.length);
        }

        return max * max;
    }
}