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
    public TreeNode increasingBST(TreeNode root) {
        TreeNode res, tmp;
        if(root.left != null){
            res = increasingBST(root.left);
            root.left = null;
            tmp = res;
            while(tmp.right != null) tmp = tmp.right;
            tmp.right = root;
        }else{
            res = root;
        }
        
        if(root.right != null){
            root.right = increasingBST(root.right);
        }
        
        return res;
    }
}