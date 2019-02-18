class Solution {
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        // 单增栈，遇到大的压入下标，遇到小的计算以其为高的面积直至可以将其压入栈
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
        
        // 这里不太明白
        while (!stack.isEmpty()) {
            int t = stack.pop();
            int area = height[t] * (stack.isEmpty() ? len : len - stack.peek() - 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}