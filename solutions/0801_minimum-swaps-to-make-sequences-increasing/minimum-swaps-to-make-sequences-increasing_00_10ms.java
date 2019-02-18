class Solution {
    public int minSwap(int[] A, int[] B) {
        // ��̬�滮����¼�����Ͳ�������ǰԪ�ص���С����
        // ÿ����һ���±꣬������������������뽻�������Խ����Ͳ����Խ�����
        int doSwap = 1, noSwap = 0;

        for (int i = 1; i < A.length; ++i) {
            if (A[i - 1] >= B[i] || B[i - 1] >= A[i]) {
                // �����Խ���
                ++doSwap;
            } else if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
                // ���뽻��
                int tmp = noSwap + 1;
                noSwap = doSwap;
                doSwap = tmp;
            } else {
                // ������
                int tmp = doSwap < noSwap ? doSwap : noSwap;
                doSwap = tmp + 1;
                noSwap = tmp;
            }
        }

        return doSwap < noSwap ? doSwap : noSwap;
    }
}