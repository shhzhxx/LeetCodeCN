class Solution {
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        // ����ջ���������ѹ���±꣬����С�ļ�������Ϊ�ߵ����ֱ�����Խ���ѹ��ջ
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
        
        // ���ﲻ̫����
        while (!stack.isEmpty()) {
            int t = stack.pop();
            int area = height[t] * (stack.isEmpty() ? len : len - stack.peek() - 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}