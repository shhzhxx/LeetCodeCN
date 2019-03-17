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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return core(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode core(int[] inorder, int il, int ir, int[] postorder, int pl, int pr){
        if(il > ir)
            return null;
        
        int rootVal = postorder[pr];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = il;
        while(rootVal != inorder[rootIndex]) ++rootIndex;
        
        root.left = core(inorder, il, rootIndex - 1, postorder, pl, pl + rootIndex - il - 1);
        root.right = core(inorder, rootIndex + 1, ir, postorder, pl + rootIndex - il, pr - 1);
        return root;
    }
}