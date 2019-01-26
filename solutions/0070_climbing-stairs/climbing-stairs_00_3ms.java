class Solution {
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        // æ¬ä½è·æ±ææ³¢é£å¥æ°åä¸æ ·ï¼å®éä¸ç¬nçº§æ¥¼æ¢¯çæ¹æ³æ°ç­äºç¬n-1çº§çæ¹æ³æ°å ä¸ç¬n-2çº§çæ¹æ³æ°ï¼åç¬1çº§å2çº§ï¼
        int n_2 = 1, n_1 = 2, res = 0;

        while (--n != 1){
            res = n_2 + n_1;
            n_2 = n_1;
            n_1 = res;
        }

        return res;
    }
}