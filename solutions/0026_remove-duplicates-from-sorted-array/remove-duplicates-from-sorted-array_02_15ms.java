class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        
        int anchor = 0;
        for(int i = 1;i < nums.length;++i){
            if(nums[i - 1] != nums[i]){
                nums[++anchor] = nums[i];
            }
        }
        
        return ++anchor;
    }
}