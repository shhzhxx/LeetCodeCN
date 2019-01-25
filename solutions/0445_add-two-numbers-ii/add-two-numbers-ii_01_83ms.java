/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack_1 = new Stack<>();
        Stack<Integer> stack_2 = new Stack<>();
        Stack<Integer> stack_3 = new Stack<>();
        
        while (l1 != null){
            stack_1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null){
            stack_2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        while (carry == 1 || !stack_1.isEmpty() || !stack_2.isEmpty()){
            int add_1 = stack_1.isEmpty() ? 0 : stack_1.pop();
            int add_2 = stack_2.isEmpty() ? 0 : stack_2.pop();
            int res = carry + add_1 + add_2;
            if(res > 9) {
                carry = 1;
                res -= 10;
            }else 
                carry = 0;
            stack_3.push(res);
        }
        
        ListNode node = new ListNode(stack_3.pop()), head = node;
        while (!stack_3.isEmpty()){
            node.next = new ListNode(stack_3.pop());
            node = node.next;
        }
        
        return head;
    }
}