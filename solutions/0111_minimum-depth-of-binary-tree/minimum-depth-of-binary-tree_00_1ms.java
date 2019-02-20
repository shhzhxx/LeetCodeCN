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
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if(left == 0)
            return 1 + right;
        
        if(right == 0)
            return 1 + left;
        
        return 1 + Math.min(left, right);
    }
}