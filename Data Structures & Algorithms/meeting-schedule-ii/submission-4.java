/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a,b)->Integer.compare(a.start, b.start));

        int rooms =0;
        PriorityQueue<Integer> q= new PriorityQueue<>(); 
        for(Interval interval : intervals)
        {
            if(!q.isEmpty() && q.peek()<=interval.start)
            {
                q.poll(); 
            }
            q.offer(interval.end);
            rooms= Math.max(rooms, q.size());
        }
        return rooms;

    }
}
