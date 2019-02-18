class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0){
            return;
        }

        int last = nums[nums.length - 1];
        for(int i = nums.length - 1;i > 0;)
            nums[i--] = nums[i];
        nums[0] = last;
        rotate(nums, --k);
    }
}