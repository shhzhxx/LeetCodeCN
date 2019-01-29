class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0)
            return res;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0)
                break;

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1, right = nums.length - 1, target = 0 - nums[i];
            while (left < right) {
                int tmp = nums[left] + nums[right];
                if (tmp > target) {
                    --right;
                } else if (tmp < target) {
                    ++left;
                } else {
                    // é²æ­¢éå¤
                    List<Integer> l = new ArrayList<>();
                    while (left < right - 1 && nums[left] == nums[left + 1]) ++left;
                    while (right > left + 1 && nums[right] == nums[right - 1]) --right;
                    l.add(nums[left]);
                    l.add(nums[i]);
                    l.add(nums[right]);
                    res.add(l);
                    --right;
                    ++left;
                }
            }
        }

        return res;
    }
}