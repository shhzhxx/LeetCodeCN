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
    // è¿­ä»£ç®æ³ï¼ä¿®æ¹çï¼ä¸ä¼ç ´ååææ çç»æ
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null)
            return lst;

        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                lst.add(root.val);
                root = root.right;
            }
        }

        return lst;
    }
}