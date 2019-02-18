class Solution {
    public boolean isPowerOfFour(int num) {
        if(num <= 0){
            return false;
        }else{
            int i = Integer.numberOfLeadingZeros(num);
            int j = Integer.numberOfTrailingZeros(num);

            return i + j == 31 && j % 2 == 0;
        }
    }
}