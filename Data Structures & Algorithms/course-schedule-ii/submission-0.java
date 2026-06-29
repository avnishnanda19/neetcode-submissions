class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[]{};
        Map<Integer, List<Integer>> adjMatrix = new HashMap<>(); 
        int[] indegree =  new int[numCourses];

        for(int[] p : prerequisites)
        {
            adjMatrix.computeIfAbsent(p[1], k->new ArrayList<>()).add(p[0]);
            indegree[p[0]]++;
        }
        List<Integer> order = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>(); 
        for(int i =0;i<numCourses;i++)
        {
            if(indegree[i]==0) q.add(i);
        }

        while(!q.isEmpty())
        {
            int p = q.poll(); 
            order.add(p);
            for(int i : adjMatrix.getOrDefault(p, Collections.emptyList()))
            {
                indegree[i]--;
                if(indegree[i]==0) q.add(i);
            }
        }
        if(order.size()!=numCourses) return result;
        return order.stream().mapToInt(Integer::intValue).toArray();

    }
}
