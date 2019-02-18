class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        // 先计算左边的累计乘积
        res[0] = 1;
        for(int i = 1;i < res.length;++i)
            res[i] = res[i - 1] * nums[i - 1];
        
        // 再算另一边
        int lastProduct = 1;
        for(int i = res.length - 2;i >= 0;--i){
            lastProduct = nums[i + 1] * lastProduct;
            res[i] *= lastProduct;
        }
        
        return res;
    }
}