class Solution {
    record Point(int x, int y){}
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Point> rottingOrange =  new LinkedList<>();
        int freshOrange = 0;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                    freshOrange++;
                else  if(grid[i][j]==2)
                   rottingOrange.offer(new Point(i,j)); 
            }
        }
        if(freshOrange==0 ) return 0;

        int[][] directions =  new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int minutes=0;
        while(!rottingOrange.isEmpty())
        {
            int size = rottingOrange.size(); 
            for(int i=0;i<size;i++)
            {
                Point p= rottingOrange.poll(); 
                int x =p.x(), y=p.y();
                for(int[] dir : directions)
                {
                    if(x+dir[0]<0 || y+dir[1]<0 || x+dir[0]>=m || y+dir[1]>=n 
                    || (grid[x+dir[0]][y+dir[1]]==0) || (grid[x+dir[0]][y+dir[1]]==2))
                    continue;
                    
                    grid[x+dir[0]][y+dir[1]]=2;
                    freshOrange--;
                    rottingOrange.offer(new Point(x+dir[0],y+dir[1]));
                    
                }
            }
            minutes++;
        }
        return freshOrange==0 ? minutes-1 : -1;
    }
}
