class Solution {
    public int trailingZeroes(int n) {
        // ��ʵ������[1..n]��ÿ��Ԫ�ص�����������������<2, 5>�Եĸ�������Ϊ2�϶���5�࣬����ֻ��Ҫ��5�ĸ���
        if(n < 5)
            return 0;
        
        int tmp = n / 5;
        return tmp + trailingZeroes(tmp);
    }
}