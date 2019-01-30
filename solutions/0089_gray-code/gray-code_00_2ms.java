class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int assist = 1, index = 1;

        while(--n >= 0){
            int tmpIndex = index;
            while(tmpIndex > 0){
                res.add(res.get(tmpIndex - 1) | assist);
                --tmpIndex;
            }
            index += index;
            assist = assist << 1;
        }

        return res;
    }
}