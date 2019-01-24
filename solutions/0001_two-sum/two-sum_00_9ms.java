class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int next;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0;i < nums.length;++i){
            next = target - nums[i];
            res[1] = i;
            if(map.containsKey(next)){
                res[0] = map.get(next);
                return res;
            }else {
                map.put(nums[i], i);
            }
        }

        return res;
    }
}