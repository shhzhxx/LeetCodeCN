class Solution {
    public boolean makesquare(int[] nums) {
        // 集合的k划分的特殊情况，k = 4
        // 递归寻找正确的划分，找到四次即返回true
        // 为了减少回溯次数，可以先对数组排序，寻找时从高值出发
        if (nums.length < 4) return false;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 4 != 0) return false;
        Arrays.sort(nums);

        for (int i = 0; i < 4; ++i)
            if (!find(nums.length - 1, sum / 4, 0, nums))
                return false;
            
        return true;
    }

    private boolean find(int num_id, int target, int curSum, int[] nums) {
        if (num_id < 0 || curSum > target) return false;

        for (int i = num_id; i >= 0; --i) {
            // 值为零表示已被使用
            if (nums[i] == 0) continue;
            // 暂存，不符合要求时再恢复
            int tmp = nums[i];
            nums[i] = 0;
            if (curSum + tmp == target || find(i - 1, target, curSum + tmp, nums)) return true;
            nums[i] = tmp;
        }

        return false;
    }
}