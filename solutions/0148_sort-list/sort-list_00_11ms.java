/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return head == null ? head : partition(head);
    }
    
    private ListNode partition(ListNode head){
        if(head.next == null)
            return head;
        // 使用快慢节点寻得当前链表的中点
        ListNode fast = head, slow = head, assist = null;
        while(fast != null && fast.next != null){
            assist = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 从中点切断，分割成两个链表
        assist.next = null;
        
        ListNode left = partition(head);
        ListNode right = partition(slow);
        
        return merge(left, right);
    }
    
    private ListNode merge(ListNode left, ListNode right){
        ListNode fakeHead = new ListNode(0), curNode = fakeHead;
        
        while(left != null && right != null){
            if(left.val < right.val){
                curNode.next = left;
                left = left.next;
            }else{
                curNode.next = right;
                right = right.next;
            }
                curNode = curNode.next;
        }
        
        if(left == null){
            curNode.next = right;
        }else{
            curNode.next = left;
        }
        
        return fakeHead.next;
    }
}