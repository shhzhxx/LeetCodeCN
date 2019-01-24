class Solution {
    public boolean increasingTriplet(int[] nums) {
        boolean preInc = false;
        int preFirst = Integer.MAX_VALUE;
        int preSecond = Integer.MAX_VALUE;

        for(int i = 0;i < nums.length - 1;++i){
            if(nums[i] < nums[i + 1]){
                if(preInc)
                    return true;
                else
                    preInc = true;

                if(nums[i + 1] > preSecond)
                    return true;
                else
                    preSecond = nums[i + 1];
                
                if(nums[i] > preFirst)
                    return true;
                else
                    preFirst = nums[i];
            }else
                preInc = false;
        }

        return false;
    }
}