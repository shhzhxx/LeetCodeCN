class Solution {
    
    int[] log;
    
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        log = new int[prices.length];
        return getM(prices, 0, prices.length - 1);
    }
    
    public int getM(int[] prices, int lt, int rt){
        if(log[lt] != 0){
            return log[lt];
        }else{
            return maxP(prices, lt, rt);
        }
    }
    
    public int maxP(int[] prices, int lt, int rt){
        if(lt >= rt){
            return 0;
        }
        
        int max = lt + 1;
        for(int i = lt + 2;i <= rt;++i){
            if(prices[i - 1] > prices[i]){
                max = i - 1;
                break;
            }
            max = i;
        }
        if(prices[lt] > prices[max]){
            return getM(prices, lt + 1, rt);
        }else{
            int left = prices[max] - prices[lt] + getM(prices, max, rt);
            int right = getM(prices, lt + 1, rt);
            log[lt] = left > right ? left : right;
            return log[lt];
        }
    }
}