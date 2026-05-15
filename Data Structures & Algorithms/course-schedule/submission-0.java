class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjMatrix = new ArrayList<>(); 
        int[] indegree = new int[numCourses];

        for(int i =0;i<numCourses;i++)
        {
            adjMatrix.add(new ArrayList<>());
        }

        for(int[] req : prerequisites)
        {
            adjMatrix.get(req[0]).add(req[1]); 
            indegree[req[1]]++;
        }

        Queue<Integer> q = new LinkedList<>(); 
        for(int i =0;i<numCourses;i++)
        {
            if(indegree[i]==0)
                q.offer(i);
        }

        while(!q.isEmpty())
        {
            int course = q.poll();
            List<Integer> followUps = adjMatrix.get(course); 
            for(int i : followUps)
            {
                indegree[i]--; 
                if(indegree[i]==0)
                {
                    q.offer(i);
                }
            }
        }

        for(int i =0;i<numCourses;i++)
        {
            if(indegree[i]!=0)
               return false;
        }
        return true;
    }
}
