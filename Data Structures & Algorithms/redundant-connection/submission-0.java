class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] indegree = new int[n + 1];
        Map<Integer, List<Integer>> adjMatrix = new HashMap<>();

        for(int[] e : edges)
        {
            adjMatrix.computeIfAbsent(e[0], k-> new ArrayList<>()).add(e[1]);
            adjMatrix.computeIfAbsent(e[1], k-> new ArrayList<>()).add(e[0]);
            indegree[e[0]]++;
            indegree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++)
        {
            if(indegree[i]==1)
                q.offer(i);
        }

        while(!q.isEmpty())
        {
            int node=q.poll(); 
            for(int i : adjMatrix.getOrDefault(node, Collections.emptyList()))
            {
                indegree[i]--;
                if(indegree[i]==1)
                    q.offer(i);
            }
        }
        for(int i=edges.length-1;i>=0;i--)
        {
            int u = edges[i][0], v=edges[i][1];

            if(indegree[u]==2 && indegree[v]==2)
                return new int[]{u, v};
        }
        return new int[0];
    }
}
