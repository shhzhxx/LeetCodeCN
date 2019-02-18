/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int index = 0;
    
    // 中序遍历，用index记录已经遍历到第几位了
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        
        int res = kthSmallest(root.left, k);
        if(index == k)
            return res;
        
        if(++index == k)
            return root.val;
        
        return kthSmallest(root.right, k);
    }
}