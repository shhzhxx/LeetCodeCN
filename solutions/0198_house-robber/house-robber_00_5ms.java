class Solution {
    public int rob(int[] nums) {
        // 似乎也跟斐波那契数列差不多
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];
        int canRobThis = nums[0], canNotRobThis = nums[1], res = 0;
        for(int i = 2;i < nums.length;++i){
            if(canRobThis + nums[i] > canNotRobThis){
                // 如果偷这一家
                res = canRobThis + nums[i];
                canRobThis = canRobThis > canNotRobThis ? canRobThis : canNotRobThis;
                canNotRobThis = res;
            }else {
                // 如果不偷这一家
                res = canNotRobThis;
                canRobThis = canNotRobThis;
                canNotRobThis = 0;
            }
        }

        return res;
    }
}