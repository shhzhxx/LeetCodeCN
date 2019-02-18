class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int row = 0, wid = 100;

        for(char ch: S.toCharArray()){
            int tmp = widths[ch - 'a'];
            if(wid + tmp > 100){
                wid = tmp;
                ++row;
            }else
                wid += tmp;
        }

        return new int[]{row, wid};
    }
}