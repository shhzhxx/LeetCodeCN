class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<Integer> curList = new LinkedList<>();
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        fsCore(nums, res, nums.length - 1, curList, 0, target);
        return new ArrayList<>(res);
    }

    private void fsCore(int[] nums, Set<List<Integer>> res, int maxIndex, List<Integer> curList, int curSum, int target){
        if(curList.size() == 4){
            if(curSum == target){
                List<Integer> tmp = new LinkedList<>(curList);
                res.add(tmp);
            }
            return;
        }

        int minIndex = 2 - curList.size();
        minIndex = -1 > minIndex ? -1 : minIndex;
        for(int i = maxIndex;i > minIndex;--i){
            curSum += nums[i];
            curList.add(nums[i]);
            fsCore(nums, res, i - 1, curList, curSum, target);
            curList.remove(curList.size() - 1);
            curSum -= nums[i];
        }
    }
}