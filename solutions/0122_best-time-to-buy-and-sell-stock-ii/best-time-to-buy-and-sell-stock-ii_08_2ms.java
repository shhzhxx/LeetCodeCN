class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0;i < prices.length;){
            for(int j = i + 1;j < prices.length; ++j){
                if(prices[j] <= prices[j-1]){
                    if(prices[j-1] > prices[i]){
                        max += prices[j -1] - prices[i];
                        i = j - 2;
                        break;
                    }else{
                        if(j - 1 == i){
                            break;
                        }else{
                            i = j - 2;
                            break;
                        }
                    }
                }
                if(j == (prices.length - 1)){
                    if(prices[j] > prices[i]){
                        max += prices[j] - prices[i];
                        i = j;
                        break;
                    }
                }
            }
            ++i;
        }
        return max;
    }
}