class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 1, res = nums[0];
        
        // ç¸å+1ï¼ ä¸å-1ï¼cntåå°é¶åæ¢ä¸ä¸ªæ°
        for(int i = 1;i < nums.length;++i){
            if(cnt == 0){
                res = nums[i];
                cnt = 1;
            }else{
                if(nums[i] == res)
                    ++cnt;
                else
                    --cnt;
            }
        }
        
        return res;
    }
}