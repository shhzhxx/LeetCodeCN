class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 1)
            return false;
        return Integer.highestOneBit(n) == Integer.lowestOneBit(n);
    }
}