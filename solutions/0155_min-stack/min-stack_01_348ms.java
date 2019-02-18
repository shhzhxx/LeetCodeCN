class MinStack {
    // ֧��push,pop,top����������ͷ���,���ֲ����������head
    private MyNode head;
    // ֧���ڳ���ʱ���ڼ�������СԪ�صĵ���ջ��ʵ���ϻ���������ͷ����СԪ�أ�
    private MyNode minValStack;

    /** initialize your data structure here. */
    public MinStack() {
        this.head = null;
        this.minValStack = null;
    }
    
    public void push(int x) {
        if(head == null){
            head = new MyNode(x);
            minValStack = new MyNode(x);
        }else{
            MyNode tmp = head;
            head = new MyNode(x);
            head.next = tmp;
            pushIntoMinValStack(x);
        }
    }
    
    private void pushIntoMinValStack(int x){
        if(minValStack == null)
            minValStack = new MyNode(x);
        else{
            if(minValStack.val >= x){
                MyNode tmp = new MyNode(x);
                tmp.next = minValStack;
                minValStack = tmp;
            }else{
                MyNode cur = minValStack;
                while(cur.next != null && cur.next.val < x) cur = cur.next;
                MyNode tmp = cur.next;
                cur.next = new MyNode(x);
                cur.next.next = tmp;
            }
        }
    }
    
    public void pop() {
        // Ҫע��ͬʱ������ջ
        if(head == null)
            return;
        else{
            removeFromMinValStack(head.val);
            head = head.next;
        }
    }
    
    private void removeFromMinValStack(int x){
        if(minValStack.val == x)
            minValStack = minValStack.next;
        else{
            MyNode cur = minValStack;
            while(cur.next.val != x) cur = cur.next;
            cur.next = cur.next.next;
        }
    }
    
    public int top() {
        return head == null ? 0 : head.val;
    }
    
    public int getMin() {
        return minValStack == null ? 0 : minValStack.val;
    }
    
    class MyNode{
        public int val;
        public MyNode next;
        
        public MyNode(int val){
            this.val = val;
            next = null;
        }
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