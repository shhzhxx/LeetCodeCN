class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int si = s.length - 1, gi = g.length - 1;

        for(;si > -1 && gi > -1;--si){
            while(gi > -1 && s[si] < g[gi]) --gi;
            if(gi != -1){
                ++res;
                --gi;
            }
        }

        return res;
    }
}