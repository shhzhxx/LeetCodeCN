class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<>(nums.length);
        subsetsCore(nums, 0, curList, res);
        res.add(new ArrayList<>());

        return res;
    }

    private void subsetsCore(int[] nums, int cnt, List<Integer> curList, List<List<Integer>> res){
        if(cnt == nums.length)
            return;
        else {
            for(int i = cnt;i < nums.length;++i){
                curList.add(nums[i]);
                res.add(new ArrayList<>(curList));
                subsetsCore(nums, i + 1, curList, res);
                curList.remove(curList.size() - 1);
            }
        }
    }
}