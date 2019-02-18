/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 复用合并两个有序链表的方法，两个两个合并
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        
        for (int i = 0; i < lists.length - 1; ++i)
            lists[i + 1] = mergeTwoLists(lists[i], lists[i + 1]);

        return lists[lists.length - 1];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curNode = new ListNode(0), head = curNode;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curNode.next = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }

        if (l1 == null)
            curNode.next = l2;
        else
            curNode.next = l1;

        return head.next;
    }
    
//     // 直接对整个数组做归并
//     public ListNode mergeKLists(ListNode[] lists) {
//         ListNode curNode = new ListNode(0), head = curNode;
//         boolean shouldStay = true;
        
//         while(shouldStay){
//             shouldStay = false;
            
//             int minVal = Integer.MAX_VALUE, minIndex = -1;
//             for(int i = 0;i < lists.length;++i)
//                 if(lists[i] != null){
//                     shouldStay = true;
//                     if(lists[i].val < minVal){
//                         minVal = lists[i].val;
//                         minIndex = i;
//                     }
//                 }
            
//             if(shouldStay){
//                 curNode.next = lists[minIndex];
//                 curNode = curNode.next;
//                 lists[minIndex] = lists[minIndex].next;
//             }
//         }
        
//         return head.next;
//     }
}