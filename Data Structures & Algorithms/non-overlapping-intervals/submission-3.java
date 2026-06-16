class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1],b[1]) );
        int end = -50001; 
        int removal = 0; 

        for(int[] i: intervals)
        {
            if(i[0]<end)
                removal++;
            else {
                end = i[1];
            }
        }
        return removal;
    }
}
