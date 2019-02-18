class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        // �ȼ�����ߵ��ۼƳ˻�
        res[0] = 1;
        for(int i = 1;i < res.length;++i)
            res[i] = res[i - 1] * nums[i - 1];
        
        // ������һ��
        int lastProduct = 1;
        for(int i = res.length - 2;i >= 0;--i){
            lastProduct = nums[i + 1] * lastProduct;
            res[i] *= lastProduct;
        }
        
        return res;
    }
}