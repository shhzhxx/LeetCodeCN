/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow;
        while(fast.next != null) fast = fast.next;

        reverse(slow);
        while(fast != null)
            if(fast.val == head.val){
                fast = fast.next;
                head = head.next;
            }else
                return false;

        return true;
    }

    private ListNode reverse(ListNode head){
        if(head.next == null)
            return head;

        ListNode next = head.next;
        head.next = null;
        reverse(next).next = head;
        return head;
    }
}