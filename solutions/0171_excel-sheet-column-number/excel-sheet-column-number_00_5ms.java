class Solution {

    public int titleToNumber(String s) {
        int res = 0;
        char[] chs = s.toCharArray();

        for(char ch: chs){
            res = ch - '@' + res * 26;
        }

        return res;
    }
}