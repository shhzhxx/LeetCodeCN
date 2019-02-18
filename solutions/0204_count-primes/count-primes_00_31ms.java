class Solution {
    public int countPrimes(int n) {
        if(n < 3)
            return 0;

        int primes = (n - 2) / 2 + 1;
        // 初始假设所有数都是素数
        boolean[] isNotPrime = new boolean[n];

        for(int i = 3;i < n;i += 2){
            if(!isNotPrime[i]) {
                for (int j = i + i; j < n; j += i) {
                    if (!isNotPrime[j] && j % 2 == 1) {
                        isNotPrime[j] = true;
                        --primes;
                    }
                }
            }
        }

        return primes;
    }
}