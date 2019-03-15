class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        return binSearch(nums, 0, nums.length - 1);
    }

    private int binSearch(int[] nums, int l, int r){
        if(l >= r)
            return l + (l == nums[l] ? 1 : 0);

        int mid = (l + r) / 2;

        if(nums[mid] == mid)
            return binSearch(nums, mid + 1, r);
        else
            return binSearch(nums, l, mid - 1);
    }
}