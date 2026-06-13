class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<int[]>> adjMap = new HashMap<>();
        for(int[] flight : flights)
        {
            int s = flight[0];
            int d = flight[1]; 
            int c =  flight[2];
            adjMap.compute(s, (key,v)->v==null ? new ArrayList<>() :  v).add(new int[]{d,c});     
        }
        int[] cost=  new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        Queue<Integer> stops = new LinkedList<>();
        stops.add(src);
        while(!stops.isEmpty() && k>=0)
        {
            k--; 

            int[] temp = Arrays.copyOf(cost, n);
            int size = stops.size();
            for(int i=0;i<size;i++)
            {
                int stop = stops.poll(); 
                for(int[] f : adjMap.getOrDefault(stop, new ArrayList<>()))
                {
                    int nc= cost[stop]+f[1];
                    if(cost[stop] != Integer.MAX_VALUE && nc<temp[f[0]])
                    {
                        stops.add(f[0]);
                        temp[f[0]] = nc;
                    }
                }
            }
            cost = temp;
        }
        return cost[dst]==Integer.MAX_VALUE ? -1 : cost[dst] ;
    }
}
