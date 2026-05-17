class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length; 
        List<int[]> intervalList = new ArrayList<>(); 

        boolean isInserted= false; 

        for(int[] i : intervals)
        {
            if(newInterval ==null || i[1]<newInterval[0])
            {
                intervalList.add(i);
            }
            else if(i[0]>newInterval[1]){
                intervalList.add(newInterval); 
                intervalList.add(i);
                newInterval=null;
            }
            else{
                newInterval[0] = Math.min(i[0], newInterval[0]);
                newInterval[1] = Math.max(i[1], newInterval[1]);
            }
        }
        if (newInterval != null) intervalList.add(newInterval);
        return intervalList.toArray(new int[intervalList.size()][]);
    }
}
