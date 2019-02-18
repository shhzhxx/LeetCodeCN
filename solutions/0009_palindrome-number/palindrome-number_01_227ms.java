class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        
        Deque<Integer> deque = new ArrayDeque<Integer>();

        while(x != 0){
            deque.addLast(x % 10);
            x /= 10;
        }

        while (!deque.isEmpty()){
            if(deque.size() == 1)
                return true;
            if(!deque.peekLast().equals(deque.peekFirst()))
                return false;
            deque.pollFirst();
            deque.pollLast();
        }

        return true;
    }
}