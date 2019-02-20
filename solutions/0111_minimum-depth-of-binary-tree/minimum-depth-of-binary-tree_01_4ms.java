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
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        return mdCore(stack, 1);
    }

    private int mdCore(Stack<TreeNode> stack, int depth){
        Stack<TreeNode> curStack = new Stack<>();

        while(!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            if(curNode.left == null && curNode.right == null)
                return depth;
            
            if(curNode.left != null)
                curStack.push(curNode.left);

            if(curNode.right != null)
                curStack.push(curNode.right);
        }

        return mdCore(curStack, depth + 1);
    }
}