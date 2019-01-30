/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // åæéæ³
        if(head == null || head.next == null)
            return null;
        
        ListNode slow = head, fast = head;
        
        while(true){
            if(fast.next == null || fast.next.next == null)
                return null;
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
                break;
        }
        
        ListNode assist = head;
        
        while(assist != slow){
            assist = assist.next;
            slow = slow.next;
        }
        
        return assist;
    }
}