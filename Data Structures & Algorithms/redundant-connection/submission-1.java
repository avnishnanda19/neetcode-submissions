class Solution {
    int[] parent; 
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n =edges.length; 
        parent = new int[n+1]; 
        rank =new int[n+1]; 
        for(int i=0;i<=n;i++)
        {
            parent[i]=i; 
            rank[i]=1;
        }

        for(int[] edge : edges)
        {
            if(!union(edge[0],edge[1]))
            {
                return edge;
            }
        }
        return new int[0];
    }

    private boolean union(int u , int v)
    {
        int p1 = findParent(u);
        int p2 = findParent(v);

        if(p1==p2) return false;

        if(rank[p2]>rank[p1])
        {
            int temp = p1; 
            p1=p2; 
            p2=temp;
        }
        parent[p2]=p1;
        rank[p1]+=rank[p2];
        return true;
    }

    private int findParent(int u)
    {
        int p =parent[u]; 
        while(p!=parent[p])
        {
            parent[p]=parent[parent[p]];
            p=parent[p];
        }
        return p;
    }
}
