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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        core(res, sb, root);
        
        return res;
    }

    private void core(List<String> res, StringBuilder sb, TreeNode root){
        if(root == null){
            return;
        }else if(root.left == null && root.right == null){
            sb.append(root.val);
            res.add(new String(sb));
            sb.setLength(sb.length() - 1);
            return;
        }
        
        int originalSize = sb.length();
        if(root.left != null){
            sb.append(root.val);
            sb.append("->");
            core(res, sb, root.left);
            sb.setLength(originalSize);
        }

        if(root.right != null){
            sb.append(root.val);
            sb.append("->");
            core(res, sb, root.right);
            sb.setLength(originalSize);
        }
    }
}