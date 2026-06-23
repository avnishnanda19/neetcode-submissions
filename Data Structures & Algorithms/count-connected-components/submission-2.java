class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjMatrix =  new HashMap<>();
        for(int[] i : edges )
        {
            adjMatrix.computeIfAbsent(i[0], k-> new ArrayList<>()).add(i[1]);
            adjMatrix.computeIfAbsent(i[1], k-> new ArrayList<>()).add(i[0]);
        }
        boolean[] visited =  new boolean[n]; 

        int connected=0;
        for(int i =0;i<n;i++)
        {
            if(!visited[i])
            {
                connected++;
                Queue<Integer> q= new LinkedList<>(); 
                visited[i]=true; 
                q.add(i);
                while(!q.isEmpty())
                {
                    int p =q.poll(); 
                    for(int j : adjMatrix.getOrDefault(p, Collections.emptyList()))
                    {
                        if(!visited[j])
                        {
                            visited[j]=true; 
                            q.add(j);
                        }
                    }
                }
            }

        }
        return connected;
    }
}
