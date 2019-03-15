class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        core(set, list, nums, 0);
        return new ArrayList<>(set);
    }

    private void core(Set<List<Integer>> set, List<Integer> list, int[] nums, int index){
        if(index == nums.length){
            set.add(new LinkedList<>(list));
            return;
        }

        core(set, list, nums, index + 1);
        list.add(nums[index]);
        core(set, list, nums, index + 1);
        list.remove(list.size() - 1);
    }
}