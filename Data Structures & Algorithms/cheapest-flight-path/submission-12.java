class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adjMatrix  = new HashMap<>(); 

        for(int[] f : flights)
        {
            int s =  f[0], d=f[1], p=f[2]; 
            adjMatrix.compute(s, (key,v)->v ==null ? new ArrayList<>() : v).add(new int[]{d, p});
        }

        int[] price = new int[n]; 
        Queue<Integer> q= new LinkedList<>(); 
        q.offer(src);
        
        while(!q.isEmpty() && k>=0)
        {
            k--;
            int size = q.size();
            int[] temp = Arrays.copyOf(price, n);
            for(int i=0;i<size;i++)
            {
                int start =  q.poll(); 
                for(int[] j : adjMatrix.getOrDefault(start, Collections.emptyList()))
                {
                    int cost = price[start]+j[1]; 
                    if(price[j[0]]==0 || temp[j[0]]>cost)
                    {
                        temp[j[0]]=cost;
                        q.add(j[0]);
                    }
                }
                
            }
            price = temp;
        }
        return price[dst]==0 ? -1 : price[dst];
    }
}
