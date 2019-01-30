/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curNode = new ListNode(0), head = curNode;

        while(l1 != null || l2 != null){
            if(l1 == null){
                curNode.next = l2;
                break;
            }else if(l2 == null){
                curNode.next = l1;
                break;
            }else {
                if(l1.val < l2.val){
                    curNode.next = l1;
                    l1 = l1.next;
                }else {
                    curNode.next = l2;
                    l2 = l2.next;
                }
            }
            curNode = curNode.next;
        }
        
        return head.next;
    }
}