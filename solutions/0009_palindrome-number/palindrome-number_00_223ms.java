class Solution {
    public boolean isPalindrome(int x) {
        // x��������ʱ�����һλҲ����Ϊ��
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;

        // ����еķ�תһ�����ֵķ���
        int rx = 0;

        while (x > rx) {
            rx = x % 10 + rx * 10;
            x /= 10;
        }

        return rx == x || rx / 10 == x;

        
//         // ˫�˶��д洢������λ
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