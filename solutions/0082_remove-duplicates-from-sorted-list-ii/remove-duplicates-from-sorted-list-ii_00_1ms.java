/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        dummyHead.next = core(dummyHead, head);
        
        return dummyHead.next;
    }
    
    private ListNode core(ListNode head, ListNode tail){
        if(tail == null || tail.next == null)
            return tail;
        
        if(tail.val != tail.next.val){
            tail.next = core(tail, tail.next);
            return tail;
        }else{
        while(tail != null && tail.val == head.next.val) tail = tail.next;
        head.next = tail;
        return core(head, tail);
        }
    }
}