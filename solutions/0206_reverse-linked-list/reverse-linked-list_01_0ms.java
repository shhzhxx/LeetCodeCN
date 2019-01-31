/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // è¿­ä»£æ³
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
            
        ListNode res = head, src = res.next;
        res.next = null;
        while(src != null){
            ListNode tmp = src.next;
            src.next = res;
            res = src;
            src = tmp;
        }
        
        return res;
    }
}