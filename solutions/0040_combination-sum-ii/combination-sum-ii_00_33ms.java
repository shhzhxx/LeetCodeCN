class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();

        if (target < 1)
            return new LinkedList<>(res);

        List<Integer> cur = new LinkedList<>();
        Arrays.sort(candidates);
        core(res, cur, candidates, candidates.length, 0, target);

        return new LinkedList<>(res);
    }

    private void core(Set<List<Integer>> res, List<Integer> cur, int[] nums, int last, int curSum, int target) {
        if (curSum == target) {
            res.add(new LinkedList<>(cur));
            return;
        }

        if (last < 0)
            return;

        for (int i = last - 1; i >= 0; --i) {
            if (curSum + nums[i] > target)
                continue;

            cur.add(nums[i]);
            core(res, cur, nums, i, curSum + nums[i], target);
            cur.remove(cur.size() - 1);
        }
    }
}