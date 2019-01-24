class Solution {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int[] res = new int[N + 1];
        int i = 0, j = N;

        for(int k = 0;k < N;++k){
            if(S.charAt(k) == 'I')
                res[k] = i++;
            else
                res[k] = j--;
        }

        res[res.length - 1] = i;

        return res;
    }
}