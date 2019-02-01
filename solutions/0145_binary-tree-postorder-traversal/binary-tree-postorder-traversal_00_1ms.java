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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lst = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;
        
        while(cur != null || !stack.isEmpty()){
            // åå¤çå·¦å­æ 
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            
            // å¦æä¸å­å¨å³å­æ æå·²å¤çè¿å³å­æ ï¼åå¤çæ ¹èç¹
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