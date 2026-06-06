class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]==b[0] ? Integer.compare(a[1],b[1]) : Integer.compare(a[0],b[0])); 

        List<int[]> resultList =new ArrayList<>();
        int[] val =intervals[0]; 

        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]>val[1])
            {
                resultList.add(val); 
                val =  intervals[i];
            }
            else{
                val[1]=Math.max(val[1],intervals[i][1]);
            }
        }
        if(resultList.size()==0 || resultList.get(resultList.size()-1)[1]<val[0])
            resultList.add(val);
        
        int[][] result =  new int[resultList.size()][2];
        int index=0;
        for(int[] i : resultList)
            result[index++]=i;
        return  result;
    }
}
