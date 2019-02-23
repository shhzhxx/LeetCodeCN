public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int units = 32, res = 0;
        
        while(units-- != 0){
            if((n & 1) == 1)
                ++res;
            n >>= 1;
        }
        
        return res;
    }
}