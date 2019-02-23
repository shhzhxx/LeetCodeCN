class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        if (m < 0)
            return false;
        int n = matrix[0].length - 1;
        if (n < 0)
            return false;

        if (matrix[0][0] > target || matrix[m][n] < target)
            return false;

        int up = 0, down = m, row;
        if (matrix[down][0] <= target)
            row = down;
        else if (matrix[up][n] >= target)
            row = up;
        else {
            while (true) {
                int mid = (up + down) / 2;
                if(mid == up)
                    return false;

                if (matrix[mid][0] > target) {
                    down = mid;
                } else if (matrix[mid][n] < target) {
                    up = mid;
                } else {
                    row = mid;
                    break;
                }
            }
        }

        return searchArray(matrix[row], target);
    }

    private boolean searchArray(int[] nums, int target) {
        if (nums[0] == target || nums[nums.length - 1] == target)
            return true;

        return core(nums, 0, nums.length - 1, target);
    }

    private boolean core(int[] nums, int left, int right, int target) {
        if (left + 1 >= right)
            return false;

        int mid = (left + right) / 2;
        if (nums[mid] == target)
            return true;
        else if (nums[mid] < target)
            return core(nums, mid, right, target);
        else
            return core(nums, left, mid, target);
    }
}