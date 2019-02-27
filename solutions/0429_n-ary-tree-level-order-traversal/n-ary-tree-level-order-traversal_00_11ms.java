/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        List<Node> last = new LinkedList<>();
        List<Node> cur = new LinkedList<>();
        if(root != null)
            last.add(root);
        
        while(!last.isEmpty()){
            List<Integer> ints = new LinkedList<>();
            cur = last;
            last = new LinkedList<>();
            
            for(Node node:cur){
                ints.add(node.val);
                last.addAll(node.children);
            }
            
            res.add(ints);
        }

        return res;
    }
}