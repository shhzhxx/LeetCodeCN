class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(0==prices.length||null==prices) return 0;
         int minPrice  = prices[0];
         int sumProfit = 0;
         for(int i=1;i<prices.length;i++){
              if(minPrice<prices[i]){
                   sumProfit += prices[i] - minPrice;
                   minPrice = prices[i];
              }else{
                   minPrice = prices[i];
              }
         }
         return sumProfit;
    }
};
