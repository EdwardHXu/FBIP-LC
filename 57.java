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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        //FBIP 2R
        //add new interval into origional list and do the same with MergeIntervals
        intervals.add(newInterval);
        if (intervals.size() <= 1)  return intervals;
        List<Interval> result = new ArrayList();
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++){
            if (intervals.get(i).start <= end)
                end = Math.max(end, intervals.get(i).end);
            else {
                result.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}