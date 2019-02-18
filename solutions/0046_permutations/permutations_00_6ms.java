class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<>(nums.length);
        permuteCore(nums, 0, curList, res);

        return res;
    }

    private void permuteCore(int[] nums, int cnt, List<Integer> curList, List<List<Integer>> res){
        if(cnt == nums.length)
            res.add(new ArrayList<>(curList));
        else {
            for(int i = cnt;i < nums.length;++i){
                swap(nums, i, cnt);
                curList.add(nums[cnt]);
                permuteCore(nums, cnt + 1, curList, res);
                curList.remove(cnt);
                swap(nums, i, cnt);
            }
        }
    }

    private void swap(int[] nums, int t0, int t1){
        int tmp = nums[t0];
        nums[t0] = nums[t1];
        nums[t1] = tmp;
    }
}