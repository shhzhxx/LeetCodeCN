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
        int carry = 0;
        int curRes;
        int add_1, add_2;
        ListNode res = new ListNode(0), head = res;

        while (true) {
            if (l1 == null)
                add_1 = 0;
            else {
                add_1 = l1.val;
                l1 = l1.next;
            }
            if (l2 == null)
                add_2 = 0;
            else {
                add_2 = l2.val;
                l2 = l2.next;
            }
            curRes = carry + add_1 + add_2;
            if (curRes > 9) {
                carry = 1;
                curRes -= 10;
            } else
                carry = 0;

            res.val = curRes;
            if(l1 != null || l2 != null || carry == 1){
                res.next = new ListNode(0);
                res = res.next;
            }else 
                break;
        }

        return head;
    }
}