/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode smallTail = smallHead;
        ListNode largeHead = new ListNode(0);
        ListNode largeTail = largeHead;
        
        while(head != null){
            if(head.val < x){
                smallTail.next = head;
                smallTail = smallTail.next;
            }else{
                largeTail.next = head;
                largeTail = largeTail.next;
            }
                head = head.next;
        }
        
        largeTail.next = null;
        smallTail.next = largeHead.next;
        
        return smallHead.next;
    }
}