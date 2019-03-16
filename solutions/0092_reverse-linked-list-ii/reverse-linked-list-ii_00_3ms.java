/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        n -= m;
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode halfTail = dummyHead;
        while(--m != 0) halfTail = halfTail.next;
        ListNode curTail = halfTail.next;
        ListNode curHead = curTail;
        
        while(n-- != 0){
            ListNode tmp = curTail.next;
            curTail.next = curTail.next.next;
            tmp.next = curHead;
            curHead = tmp;
            halfTail.next = curHead;
        }
        
        return dummyHead.next;
    }
}