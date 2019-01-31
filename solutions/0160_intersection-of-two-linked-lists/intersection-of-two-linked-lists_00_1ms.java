/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        
        ListNode curA = headA, curB = headB;
        int lenA = 1, lenB = 1;
        while(curA.next != null){
            curA = curA.next;
            ++lenA;
        }
        while(curB.next != null){
            curB = curB.next;
            ++lenB;
        }
        
        // å°¾ç»ç¹ä¸ååè¯å®ä¸ç¸äº¤
        if(curA != curB)
            return null;
        
        // ä»¤æéä»è·ç¦»å°¾ç»ç¹ç¸åé¿åº¦å¤åºå
        curA = headA;
        curB = headB;
        if(lenA > lenB){
            while(lenA != lenB){
                curA = curA.next;
                --lenA;
            }
        }else if(lenA < lenB){
            while(lenA != lenB){
                curB = curB.next;
                --lenB;
            }
        }
        
        while(curA != curB){
            curA = curA.next;
            curB = curB.next;
        }
        
        return curA;
    }
}