class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0)
            return res;

        int i = 0, j = 0, total = matrix.length * matrix[0].length;
        int lastRowUp = 0, lastColLeft = -1;
        int lastRowDown = matrix.length, lastColRight = matrix[0].length;
        int cnt = 0;

        while(cnt < total){
            for(;j < lastColRight;++j){
                res.add(matrix[i][j]);
                ++cnt;
                if(cnt == total)
                    break;
            }
            --j;++i;
            --lastColRight;
            if(cnt == total)
                break;

            for(;i < lastRowDown;++i){
                res.add(matrix[i][j]);
                ++cnt;
                if(cnt == total)
                    break;
            }
            --i;--j;
            --lastRowDown;
            if(cnt == total)
                break;

            for(;j > lastColLeft;--j){
                res.add(matrix[i][j]);
                ++cnt;
                if(cnt == total)
                    break;
            }
            ++j;--i;
            ++lastColLeft;
            if(cnt == total)
                break;

            for(;i > lastRowUp;--i){
                res.add(matrix[i][j]);
                ++cnt;
                if(cnt == total)
                    break;
            }
            ++i;++j;
            ++lastRowUp;
        }

        return res;
    }
}