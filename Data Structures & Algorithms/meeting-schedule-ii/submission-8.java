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
        Collections.sort(intervals, (a,b)->Integer.compare(a.start,b.start));

        PriorityQueue<Integer> q = new PriorityQueue<>(); 
        int rooms=0;
        int endTime=0;
        for(Interval inter : intervals)
        {
            while(!q.isEmpty() &&  inter.start>=q.peek())
            {
               q.poll(); 
            }
            q.offer(inter.end);
            rooms= Math.max(q.size(), rooms);
        }  
        return rooms;
    }
}
