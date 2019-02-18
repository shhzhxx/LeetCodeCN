class Solution {
    public String reverseWords(String s) {
        char[] chs = new char[s.length()];
        int i = 0;

        while(i < chs.length){
            if(s.charAt(i) == ' '){
                chs[i] = ' ';
                ++i;
            }else{
                int j = i, end = i;
                while(j < chs.length && s.charAt(j) != ' ') ++j;
                while(--j >= end){
                    chs[i] = s.charAt(j);
                    ++i;
                }
            }
        }

        return new String(chs);
    }
}