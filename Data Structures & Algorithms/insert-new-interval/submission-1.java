class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>(); 

        for(int [] i : intervals)
        {
            if(newInterval==null || i[1]<newInterval[0])
            {
                result.add(i);
            }
            else if(i[0]>newInterval[1])
            {
                result.add(newInterval);
                result.add(i);
                newInterval=null;
            }
            else{
                newInterval[0]=Math.min(newInterval[0],i[0]);
                newInterval[1]=Math.max(newInterval[1],i[1]);
            }
        }
        if(newInterval!=null)
        {
            result.add(newInterval);
        }
        int[][] answer = new int[result.size()][2];
        int index=0;
        for(int[] i : result)
            answer[index++]=i;
        
        return answer;
    }
}
