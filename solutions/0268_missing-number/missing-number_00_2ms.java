class Solution {
    public int missingNumber(int[] nums) {
        // 使用异或“抵消”出现的数字
        int res = nums.length;
        
        for(int i = 0;i < nums.length;++i){
            res ^= nums[i];
            res ^= i;
        }
        
        return res;
    }
}