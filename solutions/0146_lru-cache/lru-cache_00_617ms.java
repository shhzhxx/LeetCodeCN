class LRUCache {
    private int capacity;
    private LinkedList<MyPair> lst;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.lst = new LinkedList<>();
    }

    public int get(int key) {
        MyPair pair = new MyPair(key, 0);
        if (lst.contains(pair)) {
            int index = lst.indexOf(pair);
            pair = lst.get(index);
            lst.remove(index);
            lst.addFirst(pair);
            return pair.getVal();
        } else
            return -1;
    }

    public void put(int key, int value) {
        MyPair pair = new MyPair(key, value);
        if (lst.contains(pair)) {
            lst.remove(pair);
        } else if (lst.size() >= this.capacity) {
            lst.remove(this.capacity - 1);
        }
        lst.addFirst(pair);
    }

    class MyPair {
        private int key;
        private int val;

        public MyPair(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public boolean equals(int key) {
            return this.key == key;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof MyPair)
                return this.key == ((MyPair) obj).key;
            else
                return false;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */