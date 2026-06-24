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
        Collections.sort(intervals, (a,b)->(a.start==b.start) ? Integer.compare(a.end, b.end) : Integer.compare(a.start, b.start)); 

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int roomsRequired =0;
        for(Interval i : intervals)
        {
            while(!q.isEmpty() && q.peek()<=i.start)
                q.poll();
            q.add(i.end);
            roomsRequired = Math.max(roomsRequired, q.size());
        }
        return roomsRequired;
    }
}
