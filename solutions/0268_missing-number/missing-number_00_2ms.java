class Solution {
    public int missingNumber(int[] nums) {
        // ʹ����򡰵��������ֵ�����
        int res = nums.length;
        
        for(int i = 0;i < nums.length;++i){
            res ^= nums[i];
            res ^= i;
        }
        
        return res;
    }
}