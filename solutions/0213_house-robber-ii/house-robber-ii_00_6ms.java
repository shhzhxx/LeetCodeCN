class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        if(len == 1)
            return nums[0];
        if(len == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];
        
        int doRobFirst = robCore(nums, 0, len - 2);
        int noRobFirst = robCore(nums, 1, len - 1);
        
        return doRobFirst > noRobFirst ? doRobFirst : noRobFirst;
    }
    
    private int robCore(int[] nums, int start, int end){
        int robLast2 = 0;
        int robLast1 = nums[start];
        int res = 0;
        
        for(int i = start + 1;i <= end;++i){
            int tmp = robLast2 + nums[i];
            res = tmp > robLast1 ? tmp : robLast1;
            robLast2 = robLast1;
            robLast1 = res;
        }
        
        return res;
    }
}