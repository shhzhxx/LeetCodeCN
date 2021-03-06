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
    public TreeNode pruneTree(TreeNode root) {
        if(root == null)
            return root;
        
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        
        return getSum(root) > 0 ? root : null;
    }
    
    public int getSum(TreeNode root){
        return root.val + (root.left == null?0:getSum(root.left)) + (root.right == null?0:getSum(root.right));
    }
}