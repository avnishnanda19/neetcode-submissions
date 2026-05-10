class Solution {
    HashMap<Integer, Integer> parent,  rank;
    public int countComponents(int n, int[][] edges) {
        parent =new HashMap<>(); 
        rank =new HashMap<>();

        for(int i=0;i<n;i++)
        { 
            parent.put(i,i);
            rank.put(i,1);
        }

        int connected=n;
        for(int[] i : edges)
        {
            if(union(i[0], i[1]))
             connected--;
        }

        return connected;
    }

    private boolean union(int a , int b )
    { 
        int pa= find(a);
        int pb= find(b);
        if(pa==pb)
            return false; 
        if(rank.get(pa) < rank.get(pb))
        {
            int temp = pa; 
            pa =  pb;
            pb = temp; 
        }
        parent.put(pb,pa);
        rank.put(pa, rank.get(pa)+rank.get(pb));
        return true;
    }

    private int find(int a)
    { 
        int cur = a;
        while(cur != parent.get(cur))
        {
            parent.put(cur, parent.get(parent.get(cur)));
            cur=parent.get(cur);
        }
        return cur;
    }

}
