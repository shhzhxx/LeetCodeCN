/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode curNode = new ListNode(0), head = curNode;
        boolean shouldStay = true;
        
        while(shouldStay){
            shouldStay = false;
            
            int minVal = Integer.MAX_VALUE, minIndex = -1;
            for(int i = 0;i < lists.length;++i)
                if(lists[i] != null){
                    shouldStay = true;
                    if(lists[i].val < minVal){
                        minVal = lists[i].val;
                        minIndex = i;
                    }
                }
            
            if(shouldStay){
                curNode.next = lists[minIndex];
                curNode = curNode.next;
                lists[minIndex] = lists[minIndex].next;
            }
        }
        
        return head.next;
    }
}