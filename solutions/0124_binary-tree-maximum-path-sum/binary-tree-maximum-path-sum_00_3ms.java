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
    private int res = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return this.res;
    }
    
    /**
    * 如果本节点在最大路径内，则存储从下到本节点的最大路径和
    * 否则置0
    */
    private int findMax(TreeNode root){
        if(root == null)
            return 0;
        // 如果左或右子树的最大路径和小于0，则置0以消除影响
        int left = Math.max(0, findMax(root.left));
        int right = Math.max(0, findMax(root.right));
        this.res = Math.max(this.res, root.val + left + right);
        return Math.max(left, right) + root.val;
    }
}