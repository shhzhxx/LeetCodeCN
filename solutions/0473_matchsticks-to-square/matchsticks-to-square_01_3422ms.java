class Solution {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 4 != 0) return false;
        int[] subset = new int[4];
        Arrays.sort(nums);

        return dp(0, sum / 4, nums, subset);
    }

    private boolean dp(int num_id, int target, int[] nums, int[] subset) {
        if (num_id == nums.length){
            boolean res = true;
            for(int sum: subset)
                res &= sum == target;
            return res;
        }

        for (int i = 0; i < subset.length; ++i) {
            if (subset[i] + nums[num_id] > target) continue;
            subset[i] += nums[num_id];
            if (dp(num_id + 1, target, nums, subset)) return true;
            subset[i] -= nums[num_id];
        }

        return false;
    }
}