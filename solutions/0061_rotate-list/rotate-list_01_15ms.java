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
        
        // è®¡ç®é¾è¡¨é¿åº¦
        while(curNode.next != null){
            ++len;
            curNode = curNode.next;
        }
        
        tail = curNode;
        curNode = head;
        // ä¾å¦ï¼å¯¹äºæ5ä¸ªåç´ çé¾è¡¨æ¥è¯´ï¼ç§»å¨4ä¸ªä½ç½®åç§»å¨9ä¸ªä½ç½®çææç¸å
        k %= len;
        k = len - k;
        
        while(--k > 0){
            curNode = curNode.next;
        }
        
        // æè½¬
        tail.next = head;
        head = curNode.next;
        curNode.next = null;
        
        return head;
    }
}