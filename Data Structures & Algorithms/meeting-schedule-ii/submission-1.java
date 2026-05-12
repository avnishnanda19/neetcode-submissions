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
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> endTimeHeap = new PriorityQueue<>();
        
        for(Interval interval : intervals)
        {
            if(!endTimeHeap.isEmpty() && endTimeHeap.peek()<=interval.start)
            {
                endTimeHeap.poll();
            }
            endTimeHeap.offer(interval.end);
        }

        return endTimeHeap.size();
    }
}
