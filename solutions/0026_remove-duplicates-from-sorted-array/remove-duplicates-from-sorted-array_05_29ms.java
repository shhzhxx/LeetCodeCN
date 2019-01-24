class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        int anchor = 0;
        int tmp = nums[0];
        for(int i = 1;i < nums.length;++i){
            if(tmp != nums[i]){
                nums[++anchor] = nums[i];
                tmp = nums[i];
            }
        }
        return ++anchor;
    }
}