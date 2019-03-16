class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        
        while(j < nums.length){
            while(j < nums.length && nums[j] == 0) ++j;
            if(j == nums.length)
                break;
            
            nums[i++] = nums[j++];
        }
        
        while(i < nums.length) nums[i++] = 0;
    }
}