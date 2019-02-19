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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        lobCore(res, root, 0);
        Collections.reverse(res);
        
        return res;
    }

    private void lobCore(List<List<Integer>> res, TreeNode root, int depth){
        if(root == null)
            return;
        
        if(res.size() == depth)
            res.add(new ArrayList<Integer>());
        
        res.get(depth).add(root.val);

        lobCore(res, root.left, depth + 1);
        lobCore(res, root.right, depth + 1);
    }
}