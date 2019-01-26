class Solution {
    public int rob(int[] nums) {
        // ä¼¼ä¹ä¹è·ææ³¢é£å¥æ°åå·®ä¸å¤
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];
        int canRobThis = nums[0], canNotRobThis = nums[1], res = 0;
        for(int i = 2;i < nums.length;++i){
            if(canRobThis + nums[i] > canNotRobThis){
                // å¦æå·è¿ä¸å®¶
                res = canRobThis + nums[i];
                canRobThis = canRobThis > canNotRobThis ? canRobThis : canNotRobThis;
                canNotRobThis = res;
            }else {
                // å¦æä¸å·è¿ä¸å®¶
                res = canNotRobThis;
                canRobThis = canNotRobThis;
                canNotRobThis = 0;
            }
        }

        return res;
    }
}