class Solution {
    public int trailingZeroes(int n) {
        // 其实就是找[1..n]中每个元素的所有因数的序列中<2, 5>对的个数，因为2肯定比5多，所以只需要数5的个数
        if(n < 5)
            return 0;
        
        int tmp = n / 5;
        return tmp + trailingZeroes(tmp);
    }
}