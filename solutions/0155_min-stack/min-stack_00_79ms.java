class MinStack {
    // 支持push,pop,top的栈
    private Stack<Integer> mainStack;
    // 支持在常数时间内检索到最小元素的单调栈
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        this.mainStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
        // 实际上每次push只需要记录更小的值
        if(minStack.isEmpty() || minStack.peek() >= x)
            minStack.push(x);
    }

    public void pop() {
        int tmp = mainStack.pop();
        if(tmp == minStack.peek())
            minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */