class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int[] remainder = new int[K];
        int tmp = 0, res = 0;
        remainder[0] = 1;

        for(int a: A){
            tmp = ((tmp + a) % K + K) % K;
            res += remainder[tmp];
            ++remainder[tmp];
        }

        return res;
    }
}