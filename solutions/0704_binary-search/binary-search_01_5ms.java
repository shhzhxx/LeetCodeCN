class Solution {
    public int search(int[] nums, int target) {
        if(nums[0] > target || nums[nums.length - 1] < target)
            return -1;
        
        if(nums[0] == target)
            return 0;
        else if(nums[nums.length - 1] == target)
            return nums.length - 1;
        else
            return binSearch(nums, 0, nums.length - 1, target);
    }

    public int binSearch(int[] nums, int left, int right, int target){
        if(left + 1 == right)
            return -1;

        int mid = (left + right) / 2;
        if(nums[mid] == target)
            return mid;
        else if(nums[mid] > target)
            return binSearch(nums, left, mid, target);
        else
            return binSearch(nums, mid, right, target);
    }
}