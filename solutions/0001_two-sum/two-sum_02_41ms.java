class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Set<Integer> used = new HashSet<>();
        int next;
        
        for(int i = 0;i < nums.length;++i){
            if(used.contains(nums[i]))
                continue;
            res[0] = i;
            next = target - nums[i];
            for(int j = i + 1;j < nums.length;++j)
                if(nums[j] == next){
                    res[1] = j;
                    return res;
                }
            used.add(nums[i]);
        }
        return res;
    }
}