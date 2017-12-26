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
    public int minMeetingRooms(Interval[] intervals) {
        //FBIP 3R
        //maintain two arrays start and end with two pointers recording them but space complexity is not that good
        // if (intervals == null || intervals.length == 0) return 0;
        // int[] start = new int[intervals.length];
        // int[] end = new int[intervals.length];
        // for (int i = 0; i < intervals.length; i++){
        //     start[i] = intervals[i].start;
        //     end[i] = intervals[i].end;
        // }
        // Arrays.sort(start);
        // Arrays.sort(end);
        // int result = 0, endIndex = 0;
        // for (int i = 0; i < intervals.length; i++){
        //     if (start[i] < end[endIndex])
        //         result++;
        //     else 
        //         endIndex++;
        // }
        // return result;
        
        //use min heap: maintain min heap which heap size is number of meeting room
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (Interval i1, Interval i2) -> (i1.start - i2.start));    //use lamda sort with start time
        Queue<Interval> pq = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.end - i2.end;
            }
        });                                                 //override pq compare sorted with end time
        pq.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++){
            Interval interval = pq.poll();
            if (intervals[i].start >= interval.end)         //if not overlap then update end
                interval.end = intervals[i].end;
            else 
                pq.offer(intervals[i]);                     //if overlap then need one more room
            pq.offer(interval);                             //don't forget add current room back to pq
        }       
        return pq.size(); 
    }
}