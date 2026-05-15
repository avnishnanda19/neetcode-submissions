class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjMatrix = new HashMap<>(); 
        boolean[] visited = new boolean[n]; 
        int visits =0;

        for(int[] edge  : edges)
        {
            adjMatrix.putIfAbsent(edge[0], new ArrayList<>());
            adjMatrix.putIfAbsent(edge[1], new ArrayList<>());
            adjMatrix.get(edge[0]).add(edge[1]);
            adjMatrix.get(edge[1]).add(edge[0]);
        }

        Queue<int[]> q =  new LinkedList<>(); 
        q.offer(new int[]{0, -1}); 

        while(!q.isEmpty())
        {
            int[] pair = q.poll(); 
            int node = pair[0], parent= pair[1]; 
            visited[node]=true; 
            visits++;
            for(int i : adjMatrix.getOrDefault(node, new ArrayList<>()))
            {
                if(i!=parent)
                    {
                    if(visited[i]) return false;
                    q.add(new int[]{i, node});
                    }
            }

        }
        return visits==n;


    }
}
