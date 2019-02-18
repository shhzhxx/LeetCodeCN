class Solution {
    public boolean isPalindrome(int x) {
        // x不等于零时，最后一位也不能为零
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;

        // 题解中的反转一半数字的方法
        int rx = 0;

        while (x > rx) {
            rx = x % 10 + rx * 10;
            x /= 10;
        }

        return rx == x || rx / 10 == x;

        
//         // 双端队列存储单个数位
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