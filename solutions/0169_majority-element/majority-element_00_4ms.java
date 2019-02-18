class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 1, res = nums[0];
        
        // ��ͬ+1�� ��ͬ-1��cnt��������һ����
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