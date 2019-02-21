class Solution {
    public void nextPermutation(int[] nums) {
        int left = nums.length - 2;
        while(left >= 0 && nums[left] >= nums[left + 1])
            --left;

        if(left >= 0){
            int right = nums.length - 1;
            while(nums[left] >= nums[right])
                --right;
            swap(nums, left, right);
        }

        reverse(nums, left + 1);
    }

    private void reverse(int[] nums, int left){
        int right = nums.length - 1;
        while(left < right){
            swap(nums, left, right);
            ++left;
            --right;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}