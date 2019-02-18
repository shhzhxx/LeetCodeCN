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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<Integer> stack_1 = new Stack<Integer>();
        Stack<Integer> stack_2 = new Stack<Integer>();
        
        findLeaf(root1, stack_1);
        findLeaf(root2, stack_2);
        
        if(stack_1.size() != stack_2.size())
            return false;
        else {
            while (!stack_1.isEmpty()){
                if(!stack_1.pop().equals(stack_2.pop()))
                    return false;
            }
        }
        
        return true;
    }

    private void findLeaf(TreeNode root, Stack<Integer> stack){
        if(root != null){
            if(root.left == null && root.right == null)
                stack.push(root.val);
            else {
                findLeaf(root.left, stack);
                findLeaf(root.right, stack);
            }
        }
    }
}