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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return core(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode core(int[] preorder, int pl, int pr, int[] inorder, int il, int ir){
        if(pl > pr)
            return null;
        
        int rootVal = preorder[pl];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = il;
        while(inorder[rootIndex] != rootVal) ++rootIndex;
        
        root.left = core(preorder, pl + 1, pl + rootIndex - il, inorder, il, rootIndex - 1);
        root.right = core(preorder, pl + rootIndex - il + 1, pr, inorder, rootIndex + 1, ir);
        
        return root;
    }
}