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
    // è¿­ä»£ç®æ³
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null)
            return lst;

        while(root != null){
            if(root.left == null){
                lst.add(root.val);
                root = root.right;
                if(root == null){
                    if(stack.isEmpty())
                        break;
                    root = stack.pop();
                }
            }else{
                TreeNode tmp = root.left;
                root.left = null;
                stack.push(root);
                root = tmp;
            }
        }

        return lst;
    }
}