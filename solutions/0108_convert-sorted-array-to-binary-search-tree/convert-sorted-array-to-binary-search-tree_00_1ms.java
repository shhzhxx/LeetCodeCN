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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length < 1)
            return null;

        return core(nums, 0, nums.length - 1);
    }

    private TreeNode core(int[] nums, int left, int right){
        if(left > right)
            return null;
        
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = core(nums, left, mid - 1);
        root.right = core(nums, mid + 1, right);
        
        return root;
    }
}