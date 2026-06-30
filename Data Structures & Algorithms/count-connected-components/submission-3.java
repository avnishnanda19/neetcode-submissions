class Solution {
    int[] parent;
    int[] rank;
    public int countComponents(int n, int[][] edges) {
        parent= new int[n]; 
        rank = new int[n]; 

        for(int i=0;i<n;i++)
        {
            parent[i]=i; 
            rank[i]=1;
        }

        int result = n;

        for(int[] e : edges)
        {
            if(union(e[0],e[1]))
            {
                result--;
            }
        }
        return result;
    }

    private boolean union(int u , int v)
    {
        int p1= findParent(u);
        int p2= findParent(v);
        if(p1==p2) return false;

        if(rank[p2]>rank[p1])
        {
            int temp = p1; 
            p1=p2; 
            p2=temp;
        }
        rank[p1]+=rank[p2];
        parent[p2]=p1;
        return true;
    }

    private int findParent(int u)
    {
        int p = parent[u]; 

        while(p!=parent[p])
        {
            parent[p]= parent[parent[p]];
            p=parent[p];
        }

        return p;
    }
}
