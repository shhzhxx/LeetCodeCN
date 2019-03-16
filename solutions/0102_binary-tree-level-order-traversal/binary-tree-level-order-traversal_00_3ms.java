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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        if(root != null){
            queue.offer(root);
            core(res, queue);
        }

        return res;
    }

    private void core(List<List<Integer>> res, Queue<TreeNode> queue){
        Queue<TreeNode> newQueue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null)
                newQueue.offer(node.left);
            if(node.right != null)
                newQueue.offer(node.right);
        }

        res.add(list);
        if(!newQueue.isEmpty())
            core(res, newQueue);
    }
}