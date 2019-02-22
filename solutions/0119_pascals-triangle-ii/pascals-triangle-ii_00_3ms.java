class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        int row = 0;
        res.add(1);

        while(row++ < rowIndex){
            int last =res.get(0);
            for(int i = 1;i < row;++i){
                int tmp = res.get(i);
                res.set(i, last + res.get(i));
                last = tmp;
            }
            res.add(1);
        }

        return res;
    }
}