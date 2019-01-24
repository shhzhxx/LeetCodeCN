class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.titleToNumber("AA"));
    }

    public int titleToNumber(String s) {
        int res = 0;
        char[] chs = s.toCharArray();

        for(char ch: chs){
            res = ch - '@' + res * 26;
        }

        return res;
    }
}