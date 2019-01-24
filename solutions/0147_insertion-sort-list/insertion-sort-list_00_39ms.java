/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode cur = head.next, end = head, tmp;

        while(cur != null){
            tmp = head;
            if(head.val > cur.val){
                end.next = cur.next;
                cur.next = head;
                head = cur;
            }else {
                while(tmp != end && tmp.next.val < cur.val)tmp = tmp.next;

                if(tmp == end){
                    end = cur;
                }else {
                    end.next = cur.next;
                    cur.next =tmp.next;
                    tmp.next = cur;
                }
            }
            cur = end.next;
        }

        return head;
    }
}