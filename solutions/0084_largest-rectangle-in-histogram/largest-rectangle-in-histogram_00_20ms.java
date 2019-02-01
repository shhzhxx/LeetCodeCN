class Solution {
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        // åå¢æ ï¼éå°å¤§çåå¥ä¸æ ï¼éå°å°çè®¡ç®ä»¥å¶ä¸ºé«çé¢ç§¯ç´è³å¯ä»¥å°å¶åå¥æ 
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty() || height[i] > height[stack.peek()]) {
                stack.push(i);
            } else {
                int t = stack.pop();
                int area = height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(area, maxArea);
                i--;
            }
        }
        
        // è¿éä¸å¤ªæç½
        while (!stack.isEmpty()) {
            int t = stack.pop();
            int area = height[t] * (stack.isEmpty() ? len : len - stack.peek() - 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}