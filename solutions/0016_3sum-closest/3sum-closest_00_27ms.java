class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        
        for(int i = 0;i < nums.length - 2;++i){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int tmp = nums[i] + nums[left] + nums[right];
                if(Math.abs(tmp - target) < Math.abs(closest - target))
                    closest = tmp;
                
                if(tmp > target)
                    --right;
                else if(tmp < target)
                    ++left;
                else
                    return tmp;
            }
        }
        
        return closest;
    }
}