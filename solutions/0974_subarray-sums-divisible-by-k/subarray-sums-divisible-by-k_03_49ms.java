class Solution {
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, Integer> remainder = new HashMap<>();
        int tmp = 0, res = 0;
        remainder.put(0, 1);

        for(int a: A){
            tmp = ((tmp + a) % K + K) % K;
            if(!remainder.containsKey(tmp))
                remainder.put(tmp, 0);
            res += remainder.get(tmp);
            remainder.put(tmp, remainder.get(tmp) + 1);
        }

        return res;
    }
}