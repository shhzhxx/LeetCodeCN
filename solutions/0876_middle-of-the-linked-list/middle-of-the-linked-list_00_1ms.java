/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode mid = head;
        ListNode end = head;
        boolean addOne = false;

        while (end != null){
            if(addOne){
                mid = mid.next;
                addOne = false;
            }else 
                addOne = true;
            end = end.next;
        }
        
        return mid;
    }
}