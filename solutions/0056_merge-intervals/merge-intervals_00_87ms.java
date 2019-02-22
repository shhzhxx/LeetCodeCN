/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        // 使用lambda表达式还是第一次，挺简易的
        LinkedList<Interval> res = new LinkedList<>();
        intervals.sort((left, right) -> (left.start - right.start));

        for(Interval cur:intervals){
            if(res.size() == 0 || res.peekLast().end < cur.start)
                res.add(cur);
            else
                res.peekLast().end = Math.max(res.peekLast().end, cur.end);
        }
        
        return res;
    }
}