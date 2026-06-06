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
        Collections.sort(intervals, (a,b)-> a.start==b.start ? Integer.compare(a.end, b.end) :Integer.compare(a.start, b.start) );
        PriorityQueue<Integer> pq= new PriorityQueue<>(); 
        int rooms =0;

        for(Interval interval : intervals)
        {
            while(!pq.isEmpty() && interval.start>=pq.peek())
            {
                pq.poll();
            }
            pq.offer(interval.end);
            rooms = Math.max(rooms, pq.size());

        }
        return rooms;

    }
}
