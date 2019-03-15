class Solution {
    public int removeDuplicates(int[] nums) {
        int res = nums.length;
        boolean isDuplicate = false;

        for(int i = 1;i < res;++i){
            nums[i] = nums[i + nums.length - res];
            if(nums[i] == nums[i - 1]){
                if(isDuplicate){
                    --res;
                    --i;
                }else{
                    isDuplicate = true;
                }
            }else
                isDuplicate = false;
        }

        return res;
    }
}