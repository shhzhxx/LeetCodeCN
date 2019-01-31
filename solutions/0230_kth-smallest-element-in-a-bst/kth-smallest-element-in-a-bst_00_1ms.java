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
    
    // ä¸­åºéåï¼ç¨indexè®°å½å·²ç»éåå°ç¬¬å ä½äº
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