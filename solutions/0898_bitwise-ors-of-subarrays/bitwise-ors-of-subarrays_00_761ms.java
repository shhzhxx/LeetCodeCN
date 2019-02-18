class Solution {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> result = new HashSet<Integer>();
        Set<Integer> last = new HashSet<Integer>();
        Set<Integer> cur = new HashSet<Integer>();
        int[] dp = new int[A.length];
        int tmp;

        dp = A.clone();

        for (int m = 1; m < A.length + 1; ++m) {
            for (int n = 0; m + n - 1 < A.length; ++n) {
                if(dp[n] == Integer.MAX_VALUE)
                    break;
                tmp = dp[n] | A[m + n - 1];
                dp[n] = tmp;
                cur.add(tmp);
            }
            if (cur.equals(last))
                break;
            last = (Set<Integer>) ((HashSet<Integer>) cur).clone();
            cur.clear();
            result.addAll(last);
        }

        return result.size();
    }
}