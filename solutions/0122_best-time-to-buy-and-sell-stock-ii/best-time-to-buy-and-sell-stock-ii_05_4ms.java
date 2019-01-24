class Solution {
    public int maxProfit(int[] prices) {
       int max = 0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j] > prices[i] ){
                    if (j+1==prices.length || prices[j + 1] < prices[j]){
                        max += prices[j]-prices[i];
                        i = j+1;
                    }
                }else{
                    i=j;
                }
            }
        }
        return max;
    }
     
}