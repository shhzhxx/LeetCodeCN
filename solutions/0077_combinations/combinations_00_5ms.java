class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new ArrayList<>(k);
        for(int i = 0;i < k;++i)
            list.add(0);
        core(res, list, 0, 0, n, k);

        return res;
    }

    private void core(List<List<Integer>> res, List<Integer> list, int last, int index, int n, int k){
        if(index == k){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = last + 1;index < k && k - index <= n - i + 1;++i){
            list.set(index, i);
            core(res, list, i, index + 1, n, k);
        }
    }
}