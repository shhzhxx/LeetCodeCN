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
    public void flatten(TreeNode root) {
        if(root != null){
            flatten(root.right);
            flatten(root.left);
            TreeNode tmp = root.left;
            if(tmp != null) {
                while (tmp.right != null) tmp = tmp.right;
                tmp.right = root.right;
                root.right = root.left;
                root.left = null;
            }
        }
    }
}