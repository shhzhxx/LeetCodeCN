class Solution {
    public boolean canJump(int[] nums) {
        // 贪心，找能跳得范围内最大的长度
        int len = nums.length;
        // curI：当前位置，max：最远位置，nextI：下次位置
        int curI = 0, max = 0, nextI = 0;

        while(curI + nums[curI] < len - 1){
            for(int i = curI + 1;i <= curI + nums[curI];++i){
                int tmp = nums[i] + i;
                if(tmp >= max){
                    max = tmp;
                    nextI = i;
                }
            }
            if(max == curI + nums[curI])
                return false;
            else
                curI = nextI;
        }

        return true;
    }
}