class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1)
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> list = new ArrayList<>();
        IntStream a;

        for (int i = '1'; i <= '9'; ++i)
            dp(K, N - 1, (char) i, i - '0', list);

        int[] res = new int[list.size()];
        int i = 0;
        for (int num : list)
            res[i++] = num;

        return res;
    }

    private void dp(int K, int remainLen, char lastDigit, int curNum, List<Integer> list) {
        if (remainLen == 0) {
            list.add(curNum);
            return;
        }

        if (lastDigit + K <= '9') {
            dp(K, remainLen - 1, (char) (lastDigit + K), curNum * 10 + lastDigit + K - '0', list);
        }
        if (K != 0 && lastDigit - K >= '0') {
            dp(K, remainLen - 1, (char) (lastDigit - K), curNum * 10 + lastDigit - K - '0', list);
        }
    }
}