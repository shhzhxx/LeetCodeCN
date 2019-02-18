class Solution {
    public int[] diStringMatch(String S) {
        int[] res = new int[S.length() + 1];
        int i = 0, j = S.length();

        for(int k = 0;k < S.length();++k){
            if(S.charAt(k) == 'I')
                res[k] = i++;
            else
                res[k] = j--;
        }

        res[res.length - 1] = i;

        return res;
    }
}