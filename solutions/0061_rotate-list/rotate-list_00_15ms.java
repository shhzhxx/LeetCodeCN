/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int len = 1;
        ListNode curNode = head, tail;
        
        // 计算链表长度
        while(curNode.next != null){
            ++len;
            curNode = curNode.next;
        }
        
        tail = curNode;
        curNode = head;
        // 例如，对于有5个元素的链表来说，移动4个位置和移动9个位置的效果相同
        k %= len;
        k = len - k;
        
        while(--k > 0){
            curNode = curNode.next;
        }
        
        // 旋转
        tail.next = head;
        head = curNode.next;
        curNode.next = null;
        
        return head;
    }
}