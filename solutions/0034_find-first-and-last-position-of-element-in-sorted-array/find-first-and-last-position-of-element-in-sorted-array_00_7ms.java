class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] res = new int[2];
        int first = -1, last = -1, pos = -1;

        if(nums.length < 1 || nums[0] > target || nums[nums.length - 1] < target)
            pos = -1;
        else if(nums[0] == target)
            pos = 0;
        else if(nums[nums.length - 1] == target)
            pos = nums.length - 1;
        else
            pos = search(nums, 0, nums.length - 1, target);

        if(pos != -1){
            first = pos;
            last = pos;
            while(first - 1 >= 0 && nums[first - 1] == target)
                --first;
            while(last + 1 < nums.length && nums[last + 1] == target)
                ++last;
        }

        res[0] = first;
        res[1] = last;

        return res;
    }

    private int search(int[] nums, int left, int right, int target){
        if(left + 1 >= right)
            return -1;

        int mid = (left + right) / 2;
        if(nums[mid] == target)
            return mid;
        else if(nums[mid] > target)
            return search(nums, left, mid, target);
        else
            return search(nums, mid, right, target);
    }
}