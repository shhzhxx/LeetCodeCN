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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode newLeftNode = new TreeNode(v);
            newLeftNode.left = root;
            return newLeftNode;
        }else if(d == 2){
            if(root == null)
                return root;
            else{
                TreeNode newLeftNode = new TreeNode(v);
                TreeNode newRightNode = new TreeNode(v);
                newLeftNode.left = root.left;
                newRightNode.right = root.right;
                root.left = newLeftNode;
                root.right = newRightNode;
                return root;
            }
        }
        
        if(root == null)
            return root;
        else{
            root.left = addOneRow(root.left, v, d - 1);
            root.right = addOneRow(root.right, v, d - 1);
            return root;
        }
    }
}