class Solution {
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        // 本体跟求斐波那契数列一样，实际上爬n级楼梯的方法数等于爬n-1级的方法数加上爬n-2级的方法数（再爬1级和2级）
        int n_2 = 1, n_1 = 2, res = 0;

        while (--n != 1){
            res = n_2 + n_1;
            n_2 = n_1;
            n_1 = res;
        }

        return res;
    }
}