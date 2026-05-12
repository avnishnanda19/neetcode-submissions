class Solution {
    public int[][] merge(int[][] intervals) {
        Deque<int[]> intervalStack = new ArrayDeque<>(); 
        Arrays.sort(intervals, (a,b)->{
            if(a[0]==b[0])
            {
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        for(int[] i : intervals)
        {
            if(intervalStack.isEmpty())
            {
                intervalStack.push(i);
            }
            else{
                boolean merged = false;
                if(!intervalStack.isEmpty() &&
                 intervalStack.peek()[1]>= i[0])
                {
                    int[] popValue = intervalStack.pop();
                    popValue[1]=Math.max(i[1],popValue[1]);
                    intervalStack.push(popValue);
                    merged = true; 
                }
                if(!merged)
                    intervalStack.push(i);
            }
        }
        int[][] result =new int[intervalStack.size()][2];
        for(int index = intervalStack.size()-1; index>=0;index--)
        {
            result[index]=intervalStack.pop();
        }
        return result;
    }
}
