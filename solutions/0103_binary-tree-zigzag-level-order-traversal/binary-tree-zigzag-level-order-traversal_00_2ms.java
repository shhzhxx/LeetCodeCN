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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 一个栈存上一层节点，这里退栈时值加入list，叶子节点加入当前节点栈
        Stack<TreeNode> lastStack = new Stack<>(), curStack = new Stack<>(), tmpStack;
        boolean isOdd = true;
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null)
            return res;
        
        lastStack.push(root);
        while(!lastStack.isEmpty()){
            List<Integer> lst = new LinkedList<>();
            if(isOdd){
                while(!lastStack.isEmpty()){
                    TreeNode tmp = lastStack.pop();
                    lst.add(tmp.val);
                    if(tmp.left != null)
                        curStack.push(tmp.left);
                    if(tmp.right != null)
                        curStack.push(tmp.right);
                }
            }else{
                while(!lastStack.isEmpty()){
                    TreeNode tmp = lastStack.pop();
                    lst.add(tmp.val);
                    if(tmp.right != null)
                        curStack.push(tmp.right);
                    if(tmp.left != null)
                        curStack.push(tmp.left);
                }
            }
            isOdd ^= true;
            res.add(lst);
            tmpStack = lastStack;
            lastStack = curStack;
            curStack = tmpStack;
        }
        
        return res;
    }
}