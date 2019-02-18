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
    // µ›πÈÀ„∑®
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lst = new LinkedList<>();
        
        if(root != null)
            rec(root, lst);
        
        return lst;
    }
    
    private void rec(TreeNode root, List<Integer> lst){
        lst.add(root.val);
        if(root.left != null)
            rec(root.left, lst);
        if(root.right != null)
            rec(root.right, lst);
    }
}