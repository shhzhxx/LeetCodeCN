class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> YHTriangle = new ArrayList<>(numRows);

        for(int row = 0;row < numRows;++row){
            List<Integer> curRowList = new ArrayList<Integer>(row + 1);
            for(int i = 0;i < row + 1;++i){
                curRowList.add(i, 1);
            }

            if(row > 1) {
                for (int i = 1; i < row; ++i) {
                    curRowList.set(i, YHTriangle.get(row - 1).get(i - 1) + YHTriangle.get(row - 1).get(i));
                }
            }

            YHTriangle.add(row, curRowList);
        }

        return YHTriangle;
    }
}