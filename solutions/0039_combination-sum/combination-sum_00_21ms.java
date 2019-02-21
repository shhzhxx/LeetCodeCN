class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();

        if (target < 1)
            return res;

        List<Integer> cur = new LinkedList<>();
        Arrays.sort(candidates);
        core(res, cur, candidates, candidates.length - 1, 0, target);

        return res;
    }

    private void core(List<List<Integer>> res, List<Integer> cur, int[] nums, int last, int curSum, int target) {
        if (curSum == target) {
            res.add(new LinkedList<>(cur));
            return;
        }

        if (last < 0)
            return;

        for (int i = last; i >= 0; --i) {
            if (curSum + nums[i] > target)
                continue;

            cur.add(nums[i]);
            core(res, cur, nums, i, curSum + nums[i], target);
            cur.remove(cur.size() - 1);
        }
    }
}