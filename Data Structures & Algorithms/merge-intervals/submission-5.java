class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals ,(a,b)-> (a[0]==b[0]) ? Integer.compare(a[1],b[1]) : Integer.compare(a[0],b[0])); 

        List<int[]> mergedList = new ArrayList<>();
        int[] interval = intervals[0];
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]<=interval[1])
            {
                interval[1]=Math.max(interval[1], intervals[i][1]);
            }
            else{
                mergedList.add(interval);
                interval = intervals[i];
            }
        }
        mergedList.add(interval);
        int[][] result = new int[mergedList.size()][];
        int index=0; 
        for(int[] i : mergedList)
            result[index++] =i;
        return result;
    }
}
