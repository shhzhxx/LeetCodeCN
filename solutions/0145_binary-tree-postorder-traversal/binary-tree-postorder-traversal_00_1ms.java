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
    // 迭代算法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lst = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;
        
        while(cur != null || !stack.isEmpty()){
            // 先处理左子树
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            
            // 如果不存在右子树或已处理过右子树，则处理根节点
            cur = stack.peek();
            if(cur.right == null || last == cur.right){
                stack.pop();
                lst.add(cur.val);
                last = cur;
                cur = null;
            }else{
                cur = cur.right;
            }
        }
        
        return lst;
    }
}