class Solution {
    public int search(int[] nums, int target) {
        int index = -1;

        if (nums.length < 1 || (nums[0] <= nums[nums.length - 1] && (nums[0] > target || nums[nums.length - 1] < target)))
            return index;

        return binSearch(nums, 0, nums.length - 1, target);
    }

    private int binSearch(int[] nums, int left, int right, int target) {
        if (left > right)
            return -1;

        if (nums[left] == target)
            return left;
        else if (nums[right] == target)
            return right;
        else {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else {
                if ((nums[left] < target && target < nums[mid]) || (nums[left] > nums[mid] && (target < nums[mid] || target > nums[left])))
                    return binSearch(nums, left + 1, mid - 1, target);
                else
                    return binSearch(nums, mid + 1, right - 1, target);
            }
        }
    }
}