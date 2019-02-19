class Solution {
    public int jump(int[] nums) {
        // 贪心，找能跳得范围内最大的长度
        int len = nums.length;
        
        if(len < 2)
            return 0;
        
        // curI：当前位置，cnt：跳跃次数，max：最远位置，nextI：下次位置
        int curI = 0, cnt = 1, max = 0, nextI = 0;
        
        while(curI + nums[curI] < len - 1){
            for(int i = curI + 1;i <= curI + nums[curI];++i){
                int tmp = nums[i] + i;
                if(tmp >= max){
                    max = tmp;
                    nextI = i;
                }
            }
            ++cnt;
            curI = nextI;
        }
        
        return cnt;
    }
}