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
    * ������ڵ������·���ڣ���洢���µ����ڵ�����·����
    * ������0
    */
    private int findMax(TreeNode root){
        if(root == null)
            return 0;
        // �����������������·����С��0������0������Ӱ��
        int left = Math.max(0, findMax(root.left));
        int right = Math.max(0, findMax(root.right));
        this.res = Math.max(this.res, root.val + left + right);
        return Math.max(left, right) + root.val;
    }
}