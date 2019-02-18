class Solution {
    public int countSegments(String s) {
        int res = 0, i = 0;
        char[] chs = s.toCharArray();

        while(i < chs.length){
            while (i < chs.length && chs[i] == ' ') ++i;
            if(i < chs.length && chs[i] != ' ')
                ++res;
            while (i < chs.length && chs[i] != ' ') ++i;
        }

        return res;
    }
}