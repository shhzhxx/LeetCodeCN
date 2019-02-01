class Solution {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int row = matrix.length;
        if (row == 0)
            return res;

        int col = matrix[0].length;
        int[] heights = new int[col];

        // ç±»æ¯84é¢ï¼è®¡ç®ä»¥æ¯ä¸å±ä¸ºåºæ¶çæå¤§é¢ç§¯
        for (int i = 0; i < row; ++i) {
            // è®¡ç®å¾å°å½åå±çæ±ç¶å¾
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
                    // ä»¥ä¸ä¸ä¸ªæå¤§é«åº¦ä¸ºé«ï¼å®½å³ä¸ºåä¸ä¸æ¡æå¤§é«åº¦ä¸å½åç´¢å¼çç´¢å¼è·ç¦»
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