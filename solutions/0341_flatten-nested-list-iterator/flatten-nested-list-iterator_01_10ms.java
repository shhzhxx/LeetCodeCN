/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private List<NestedInteger> curList;
    private int curIndex;
    private Stack<List<NestedInteger>> listStack;
    private Stack<Integer> indexStack;
    private int nextInt;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.curList = nestedList;
        this.curIndex = 0;
        this.listStack = new Stack<>();
        this.indexStack = new Stack<>();
    }

    @Override
    public Integer next() {
        return nextInt;
    }

    @Override
    public boolean hasNext() {
        boolean findNext;
        if(curIndex < curList.size()){
            if (curList.get(curIndex).isInteger()) {
                findNext = true;
                nextInt = curList.get(curIndex).getInteger();
                ++curIndex;
                while (curIndex >= curList.size() && !listStack.isEmpty()) {
                    curIndex = indexStack.pop();
                    curList = listStack.pop();
                }
            } else{
                int tmpIndex = curIndex;
                indexStack.push(++curIndex);
                listStack.push(curList);
                curIndex = 0;
                curList = curList.get(tmpIndex).getList();
                findNext = hasNext();
            }
        }else{
            if(!listStack.isEmpty()){
                while (curIndex >= curList.size() && !listStack.isEmpty()) {
                    curIndex = indexStack.pop();
                    curList = listStack.pop();
                }
                findNext = hasNext();
            }else 
                findNext = false;
        }
        return findNext;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */