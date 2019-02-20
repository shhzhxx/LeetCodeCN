/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1)
            return head;
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slow = head, fast = head, lastTail = dummyHead;
        int tmpK;

        do{
            slow = fast;
            tmpK = k;

            while(tmpK-- > 0 && fast != null) fast = fast.next;

            if(tmpK == -1){
                ListNode tmpHead = slow, tmpSub = slow.next, tmpNode;

                while(tmpSub != fast){
                    tmpNode = tmpSub.next;
                    tmpSub.next = tmpHead;
                    tmpHead = tmpSub;
                    tmpSub = tmpNode;
                }

                lastTail.next = tmpHead;
                lastTail = slow;
                lastTail.next = fast;
            }
        }while(tmpK == -1);

        return dummyHead.next;
    }
}