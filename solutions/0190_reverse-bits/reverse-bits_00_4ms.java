public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int units = 32, res = 0;
        
        while(units-- != 0){
            res <<= 1;
            res += n & 1;
            n >>= 1;
        }
        
        return res;
    }
}