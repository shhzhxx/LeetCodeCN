class Solution {
    public int search(int[] nums, int target) {
        // è¿­ä»£æ³
        int left = 0, mid, right = nums.length - 1;

        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid + 1;
            else
                right = right - 1;
        }

        return -1;
    }
}