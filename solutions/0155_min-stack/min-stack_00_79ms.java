class MinStack {
    // æ¯æpush,pop,topçæ 
    private Stack<Integer> mainStack;
    // æ¯æå¨å¸¸æ°æ¶é´åæ£ç´¢å°æå°åç´ çåè°æ 
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        this.mainStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
        // å®éä¸æ¯æ¬¡pushåªéè¦è®°å½æ´å°çå¼
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