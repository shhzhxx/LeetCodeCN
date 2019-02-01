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
    // éå½ç®æ³
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new LinkedList<>();
        if(root != null)
            rec(root, lst);
        return lst;
    }
    
    private void rec(TreeNode root, List<Integer> lst){
        if(root.left != null)
            rec(root.left, lst);
        lst.add(root.val);
        if(root.right != null)
            rec(root.right, lst);
    }
}