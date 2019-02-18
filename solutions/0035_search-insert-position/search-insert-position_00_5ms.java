class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length < 1)
            return 0;
        
        int rightVal = nums[nums.length - 1];

        if (target <= nums[0])
            return 0;
        else if (target == rightVal)
            return nums.length - 1;
        else if (target > rightVal)
            return nums.length;
        else return siCore(nums, 0, nums.length - 1, target);
    }

    private int siCore(int[] nums, int left, int right, int target) {
        if (left + 1 == right)
            return right;

        int mid = (left + right) / 2, midVal = nums[mid];

        if (midVal == target)
            return mid;
        else if (midVal < target)
            return siCore(nums, mid, right, target);
        else
            return siCore(nums, left, mid, target);
    }
}