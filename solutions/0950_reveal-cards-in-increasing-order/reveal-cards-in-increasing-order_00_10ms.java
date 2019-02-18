class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // 按照题目要求构造数组，逆推的过程比较简单，由于涉及两头的插入和删除，所以选用双端队列Deque
        Deque<Integer> deque = new ArrayDeque<Integer>(deck.length);
        Arrays.sort(deck);
        int[] res = new int[deck.length];
        deque.offerFirst(deck[deck.length - 1]);

        for(int i = deck.length - 2;i > -1;--i){
            deque.offerFirst(deque.pollLast());
            deque.offerFirst(deck[i]);
        }

        for(int i = 0;i < res.length;++i)
            res[i] = deque.pollFirst();

        return res;
    }
}