/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    private TreeNode cur;
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        this.cur = root;
    }
    
    /** @return the next smallest number */
    public int next() {
        if(cur != null){
            stack.push(cur);
            cur = cur.left;
            return next();
        }else{
            cur = stack.pop();
            int val = cur.val;
            cur = cur.right;
            return val;
        }
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */