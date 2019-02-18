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
        
        // ����������
        while(curNode.next != null){
            ++len;
            curNode = curNode.next;
        }
        
        tail = curNode;
        curNode = head;
        // ���磬������5��Ԫ�ص�������˵���ƶ�4��λ�ú��ƶ�9��λ�õ�Ч����ͬ
        k %= len;
        k = len - k;
        
        while(--k > 0){
            curNode = curNode.next;
        }
        
        // ��ת
        tail.next = head;
        head = curNode.next;
        curNode.next = null;
        
        return head;
    }
}