class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(Arrays.stream(gas).sum()-Arrays.stream(cost).sum()<0)
            return -1;

        int total=0; 
        int result=0;

        for(int i=0;i<gas.length;i++)
        {
            total+=gas[i]-cost[i]; 
            if(total<0)
            {
                result=i+1; 
                total=0;
            }
        }
        return result;
    }
}
