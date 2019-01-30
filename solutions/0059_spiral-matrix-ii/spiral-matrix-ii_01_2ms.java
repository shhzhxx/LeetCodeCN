class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 0, j = 0, total = n * n;
        int lastRowUp = 0, lastColLeft = -1;
        int lastRowDown = n, lastColRight = n;
        int cnt = 1;

        while(cnt <= total){
            for(;j < lastColRight;++j){
                res[i][j] = cnt;
                ++cnt;
                if(cnt > total)
                    break;
            }
            --j;++i;
            --lastColRight;

            for(;i < lastRowDown;++i){
                res[i][j] = cnt;
                ++cnt;
                if(cnt > total)
                    break;
            }
            --i;--j;
            --lastRowDown;

            for(;j > lastColLeft;--j){
                res[i][j] = cnt;
                ++cnt;
                if(cnt > total)
                    break;
            }
            ++j;--i;
            ++lastColLeft;

            for(;i > lastRowUp;--i){
                res[i][j] = cnt;
                ++cnt;
                if(cnt > total)
                    break;
            }
            ++i;++j;
            ++lastRowUp;
        }

        return res;
    }
}