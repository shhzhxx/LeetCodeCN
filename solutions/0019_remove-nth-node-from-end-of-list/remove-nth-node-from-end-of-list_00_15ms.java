/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 链表的题目使用双指针法似乎比较普遍，针对一趟扫描这种要求
        ListNode slow = head, fast = head;
        
        for(int i = 0;i < n;++i)
            fast = fast.next;
        
        if(fast == null){
            head = head.next;
        }else{
            while(fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
        }
        
        return head;
    }
}