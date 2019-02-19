class Solution {
    private int sqrtCore(int x, int left, int right){
        if(left + 1 == right)
            return left;

        int mid = (left + right) / 2;
        int midSquare = mid * mid;
        if(midSquare == x)
            return mid;
        else if(midSquare < x)
            return sqrtCore(x, mid, right);
        else
            return sqrtCore(x, left, mid);
    }

    public int mySqrt(int x) {
        int left = 0, right = 1 + x / 2;
        right = 46340 < right ? 46340 : right;

        if(left * left == x)
            return left;
        if(right * right <= x)
            return right;

        return sqrtCore(x, left, right);
    }
}