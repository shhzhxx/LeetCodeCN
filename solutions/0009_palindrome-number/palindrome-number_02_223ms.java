class Solution {
    public boolean isPalindrome(int x) {
        // xä¸ç­äºé¶æ¶ï¼æåä¸ä½ä¹ä¸è½ä¸ºé¶
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;

        // é¢è§£ä¸­çåè½¬ä¸åæ°å­çæ¹æ³
        int rx = 0;

        while (x > rx) {
            rx = x % 10 + rx * 10;
            x /= 10;
        }

        return rx == x || rx / 10 == x;

        
//         // åç«¯éåå­å¨åä¸ªæ°ä½
//         Deque<Integer> deque = new ArrayDeque<Integer>();

//         while(x != 0){
//             deque.addLast(x % 10);
//             x /= 10;
//         }

//         while (!deque.isEmpty()){
//             if(deque.size() == 1)
//                 return true;
//             if(!deque.peekLast().equals(deque.peekFirst()))
//                 return false;
//             deque.pollFirst();
//             deque.pollLast();
//         }

//         return true;
//     }
    }
}