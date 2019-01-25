class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // æç§é¢ç®è¦æ±æé æ°ç»ï¼éæ¨çè¿ç¨æ¯è¾ç®åï¼ç±äºæ¶åä¸¤å¤´çæå¥åå é¤ï¼æä»¥éç¨åç«¯éåDeque
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