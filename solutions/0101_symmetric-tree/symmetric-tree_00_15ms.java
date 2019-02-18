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
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetry(root, root);
    }
    
    public boolean checkSymmetry(TreeNode p, TreeNode q){
        if(p == null && q == null)
            return true;
        else
            return p != null && q != null && p.val == q.val && checkSymmetry(p.left, q.right) && checkSymmetry(p.right, q.left);
    }
}