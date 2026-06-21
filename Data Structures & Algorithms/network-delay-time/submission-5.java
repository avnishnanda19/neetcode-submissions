class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjMap =  new HashMap<>(); 

        for(int[]  time  : times)
        {
            int[] node = new int[]{time[1], time[2]}; 
            adjMap.putIfAbsent(time[0], new ArrayList<>()); 
            adjMap.get(time[0]).add(node);
        }

        boolean[] dist= new boolean[n]; 
        // Arrays.fill(dist, Integer.MAX_VALUE); 

        PriorityQueue<int[]> move =  new PriorityQueue<>((a, b)-> Integer.compare(a[1],b[1]));
        move.add(new int[]{k, 0}); 

        int t =0;
        while(!move.isEmpty())
        {
            int[] node = move.poll(); 
            int start =  node[0]; 
            int time = node[1]; 
            if(dist[start-1]) continue;
            dist[start-1] = true;
            t=time;

            for(int[] i : adjMap.getOrDefault(start ,  new ArrayList<>()))
            {
                if(!dist[i[0]-1])
                {
                    move.add(new int[]{i[0], i[1]+time}); 
                }
            }
        }

        for(boolean visit : dist)
        {
            if(!visit) return -1;
        }
        return t;
    }
}
