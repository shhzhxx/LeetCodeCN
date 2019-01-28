class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int start = 0, end = 0;
        
        // åç¨æ ¹æ®æ°ç»éç0åå²æ°ç»
        while(end < nums.length){
            while(end < nums.length && nums[end] != 0) ++end;
            if(end < nums.length && nums[end] == 0)
                max = max > 0 ? max : 0;
            int tmp = maxProductWithoutZero(nums, start, end - 1);
            max = max > tmp ? max : tmp;
            start = end + 1;
            ++end;
        }
        
        return max;
    }
    
    private int maxProductWithoutZero(int[] nums, int start, int end){
        if(start > end)
            return -1;
        else if(start == end)
            return nums[start];
        
        int max = Integer.MIN_VALUE;
        int lastProduct = 1;
        for(int i = start;i <= end;++i){
            lastProduct = nums[i] * lastProduct;
            max = max > lastProduct ? max : lastProduct;
        }
        
        lastProduct = 1;
        for(int i = end;i >= start;--i){
            lastProduct = nums[i] * lastProduct;
            max = max > lastProduct ? max : lastProduct;
        }
        
        return max;
    }
}