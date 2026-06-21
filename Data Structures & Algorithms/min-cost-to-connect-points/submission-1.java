class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashMap<Integer, List<int[]>> adjMatrix  = new HashMap<>(); 
        int n = points.length; 
        for(int i =0;i<n-1;i++)
        {
            int[] p1= points[i]; 
            for(int j =i+1;j<n;j++)
            {
                int[] p2= points[j]; 
                int distance = distance(p1,p2);
                adjMatrix.compute(i, (k,v)-> v==null?  new ArrayList<>() : v).add(new int[]{j,distance});
                adjMatrix.compute(j, (k,v)-> v==null?  new ArrayList<>() : v).add(new int[]{i,distance});
            }
        }

        Set<Integer> visited  = new HashSet<>(); 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.offer(new int[]{0,0}); 
        int totalDistance=0;

        while(!pq.isEmpty()  && visited.size()<n)
        {
            int[] p=pq.poll(); 
            if(visited.contains(p[0]))
             continue;
            visited.add(p[0]);
            totalDistance+=p[1];
            for(int[] k : adjMatrix.getOrDefault(p[0], Collections.emptyList()))
            {
                if(!visited.contains(k[0]))
                    pq.offer(k);
            }
        }
        return totalDistance;
    }
    private int distance(int[] p1, int[] p2)
    {
        return Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]);
    }
}
