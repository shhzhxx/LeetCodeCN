class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int cur = 0;
        
        while(cur < len){
            if(nums[cur] == val)
                nums[cur] = nums[--len];
            else
                ++cur;
        }
        
        return len;
    }
}