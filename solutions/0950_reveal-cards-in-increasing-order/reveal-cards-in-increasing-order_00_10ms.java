class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // ������ĿҪ�������飬���ƵĹ��̱Ƚϼ򵥣������漰��ͷ�Ĳ����ɾ��������ѡ��˫�˶���Deque
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