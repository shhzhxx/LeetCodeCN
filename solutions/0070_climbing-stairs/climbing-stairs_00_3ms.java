class Solution {
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        // �������쳲���������һ����ʵ������n��¥�ݵķ�����������n-1���ķ�����������n-2���ķ�����������1����2����
        int n_2 = 1, n_1 = 2, res = 0;

        while (--n != 1){
            res = n_2 + n_1;
            n_2 = n_1;
            n_1 = res;
        }

        return res;
    }
}