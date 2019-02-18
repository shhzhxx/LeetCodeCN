class Solution {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int row = matrix.length;
        if (row == 0)
            return res;

        int col = matrix[0].length;
        int[] heights = new int[col];

        // ���84�⣬������ÿһ��Ϊ��ʱ��������
        for (int i = 0; i < row; ++i) {
            // ����õ���ǰ�����״ͼ
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == '0')
                    heights[j] = 0;
                else
                    ++heights[j];
            }

            Stack<Integer> stack = new Stack<>();

            for (int j = 0; j < col; ++j) {
                if (stack.isEmpty() || heights[j] > heights[stack.peek()]) {
                    stack.push(j);
                } else {
                    // ����һ�����߶�Ϊ�ߣ���Ϊ����һ�����߶��뵱ǰ��������������
                    int lastMaxIndex = stack.pop();
                    int area = heights[lastMaxIndex] * (stack.isEmpty() ? j : j - stack.peek() - 1);
                    res = res > area ? res : area;
                    --j;
                }
            }

            while (!stack.isEmpty()) {
                int lastMaxIndex = stack.pop();
                int area = heights[lastMaxIndex] * (stack.isEmpty() ? col : col - stack.peek() - 1);
                res = res > area ? res : area;
            }
        }

        return res;
    }
}