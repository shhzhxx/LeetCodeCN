class Solution {
    public void sortColors(int[] nums) {
        // �±���low֮ǰ�Ķ���0����high֮��Ķ���2
        int low = 0, high = nums.length - 1;
        int i = 0;
        
        while (i <= high) {
            if (nums[i] == 0) {
                nums[i] = nums[low];
                nums[low] = 0;
                ++i;
                ++low;
            } else if (nums[i] == 1)
                ++i;
            else {
                nums[i] = nums[high];
                nums[high] = 2;
                --high;
            }
        }
    }
}