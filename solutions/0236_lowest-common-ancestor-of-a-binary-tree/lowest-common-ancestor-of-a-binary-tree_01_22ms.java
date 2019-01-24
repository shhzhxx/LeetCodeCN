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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == q) return p;

        List<TreeNode> pAncestors = new ArrayList<>();
        List<TreeNode> qAncestors = new ArrayList<>();
        hasChildX(root, p, pAncestors);
        hasChildX(root, q, qAncestors);

        for (TreeNode pAncestor : pAncestors) {
            if (qAncestors.contains(pAncestor))
                return pAncestor;
        }
        
        return null;
    }

    public boolean hasChildX(TreeNode root, TreeNode x, List<TreeNode> ancestors){
        if(root == x){
            ancestors.add(root);
            return true;
        }

        if(root == null)
            return false;

        if(hasChildX(root.left, x, ancestors) || hasChildX(root.right, x, ancestors)){
            ancestors.add(root);
            return true;
        }

        return false;
    }
}