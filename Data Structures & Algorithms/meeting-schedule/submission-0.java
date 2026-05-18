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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size()==0) return true;
        Collections.sort(intervals, (a,b)-> {
            if(a.start==b.start)
                return Integer.compare(a.end, b.end); 
                return Integer.compare(a.start, b.start);
        });
        int end = intervals.get(0).end;
        for(int i =1;i<intervals.size();i++)
        {
            if(intervals.get(i).start<end){
                return false; 
            }
            end = intervals.get(i).end;
        }
        return true;
    }
}
