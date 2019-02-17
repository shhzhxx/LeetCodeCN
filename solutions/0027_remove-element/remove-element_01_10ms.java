class Solution {
    public int removeElement(int[] nums, int val) {
        int last = 0;
        for(int cur = 0;cur < nums.length;++cur){
            if(nums[cur] != val){
                nums[last] = nums[cur];
                ++last;
            }
        }
        
        return last;
    }
}