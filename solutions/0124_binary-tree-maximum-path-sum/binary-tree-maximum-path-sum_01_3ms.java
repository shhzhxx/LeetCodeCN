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
    private int res = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return this.res;
    }
    
    /**
    * å¦ææ¬èç¹å¨æå¤§è·¯å¾åï¼åå­å¨ä»ä¸å°æ¬èç¹çæå¤§è·¯å¾å
    * å¦åç½®0
    */
    private int findMax(TreeNode root){
        if(root == null)
            return 0;
        // å¦æå·¦æå³å­æ çæå¤§è·¯å¾åå°äº0ï¼åç½®0ä»¥æ¶é¤å½±å
        int left = Math.max(0, findMax(root.left));
        int right = Math.max(0, findMax(root.right));
        this.res = Math.max(this.res, root.val + left + right);
        return Math.max(left, right) + root.val;
    }
}