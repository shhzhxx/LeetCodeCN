class Solution {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int row = matrix.length;
        if (row == 0)
            return res;

        int col = matrix[0].length;
        int[] heights = new int[col];

        // 类比84题，计算以每一层为底时的最大面积
        for (int i = 0; i < row; ++i) {
            // 计算得到当前层的柱状图
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
                    // 以上一个最大高度为高，宽即为再上一条最大高度与当前索引的索引距离
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