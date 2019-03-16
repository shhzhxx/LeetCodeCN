class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 2 || n == 0)
            return false;
        if(n == 3 || n == 1)
            return true;
        
        return n % 3 == 0 ? isPowerOfThree(n / 3) : false;
    }
}