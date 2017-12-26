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
    public boolean canAttendMeetings(Interval[] intervals) {
        //FBIP 2R
        //use lamda expression to sort start time of intervals
        if (intervals.length < 2)   return true;
        Arrays.sort(intervals, (Interval i1, Interval i2) -> (i1.start - i2.start));
        int end = intervals[0].end;
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i].start < end)
                return false;
            end = intervals[i].end;
        }
        return true;
    }
}