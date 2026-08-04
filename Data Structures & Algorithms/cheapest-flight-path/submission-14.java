class Solution {
    record Flight(int dest , int cost){}
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,List<Flight>> adjMap= new HashMap<>();

        for(int[] f : flights)
        {
            int s = f[0]; 
            int d = f[1]; 
            int c = f[2];

            adjMap.computeIfAbsent(s, key-> new ArrayList<>()).add(new Flight(d,c));
        }

        int[] prices= new int[n]; 
        Arrays.fill(prices,-1);
        Queue<Integer> q= new LinkedList<>(); 
        q.add(src);
        prices[src]=0;

        while(!q.isEmpty() && k>=0)
        {
            k--;
            int size= q.size(); 
            int[] temp = Arrays.copyOf(prices, n);
            for(int i=0;i<size;i++)
            {
                int current = q.poll();
                int currentCost= prices[current];
                for(Flight f : adjMap.getOrDefault(current, Collections.emptyList())){
                    
                    int cost= f.cost();
                    int d=f.dest(); 
                    
                    if(temp[d]==-1 || temp[d]>currentCost+cost)
                    {
                        temp[d]=currentCost+cost; 
                        q.add(d);
                    }
                }
            }
            prices=temp;
            // for(int i : prices)
            // System.out.print(i+" "); 
            // System.out.println();
        }
        if(prices[dst]==-1)
            return -1;
        return prices[dst];
    }
}
