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
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        
        for(int i = 1;i < list.size();++i) {
            if (list.get(i) <= list.get(i - 1))
                return false;
        }
        
        return true;    
    }

    private void inOrder(TreeNode root, List<Integer> list){
        if(root == null)
            return;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}