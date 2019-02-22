class Solution {
    public String getPermutation(int n, int k) {
        // 可以选择直接计算出第k个位置的排列
        // 详见https://bangbingsyb.blogspot.com/2014/11/leetcode-permutation-sequence.html
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>(9);
        int[] factorial = new int[n];
        --k;

        for (int i = 1; i <= n; ++i)
            list.add(i);

        factorial[0] = 1;
        for (int i = 1; i < n; ++i)
            factorial[i] = factorial[i - 1] * i;

        while (n-- != 0) {
            sb.append(list.remove(k / factorial[n]));
            k = k % factorial[n];
        }

        return new String(sb);
    }
}