class Solution {
    public int countPrimes(int n) {
        if(n < 3)
            return 0;

        int primes = (n - 2) / 2 + 1;
        // åå§åè®¾æææ°é½æ¯ç´ æ°
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