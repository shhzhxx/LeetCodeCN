class Solution {
    public int maxProfit(int[] prices) {
        int dp = 0;
        int min = Integer.MAX_VALUE;

        for(int price: prices){
            int tmp = price - min;
            dp = dp > tmp ? dp : tmp;
            min = min < price ? min : price;
        }

        return dp < 0 ? 0 : dp;
    }
}