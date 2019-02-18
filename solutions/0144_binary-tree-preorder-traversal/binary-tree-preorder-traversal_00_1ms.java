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
    // µü´úËã·¨
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lst = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root == null)
                root = stack.pop();

            lst.add(root.val);
            if (root.left == null) {
                root = root.right;
            } else {
                if (root.right != null)
                    stack.push(root.right);
                root = root.left;
            }
        }

        return lst;
    }
}