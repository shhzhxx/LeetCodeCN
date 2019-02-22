class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        if (nums.length == 0)
            return res;

        List<Integer> cur = new LinkedList<>();
        puCore(res, cur, nums, 0);

        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void puCore(List<List<Integer>> res, List<Integer> cur, int[] nums, int point) {
        if (point == nums.length) {
            res.add(new LinkedList<>(cur));
            return;
        }

        Set<Integer> last = new HashSet<>();

        for (int i = point; i < nums.length; ++i) {
            // 去重。原理是每次选取一个数加入集合，剩下的数继续递归
            if (last.contains(nums[i]))
                continue;

            last.add(nums[i]);
            swap(nums, i, point);
            cur.add(nums[point]);
            puCore(res, cur, nums, point + 1);
            cur.remove(cur.size() - 1);
            swap(nums, i, point);
        }
    }
}