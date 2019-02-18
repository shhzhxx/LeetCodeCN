class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        
        for(int i = 0;i < prices.length;++i){
            int j = i + 1;
            for(;j < prices.length;++j){
                if(prices[j] < prices[j - 1]){
                    break;
                }
            }
            if(prices[--j] > prices[i]){
                max += prices[j] - prices[i];
                i = j;
            }
        }
        
        return max;
    }
}