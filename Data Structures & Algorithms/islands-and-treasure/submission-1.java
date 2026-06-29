class Solution {
    record Point(int x, int y){}
    public void islandsAndTreasure(int[][] grid) {
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int m =grid.length;
        int n =grid[0].length;

        Queue<Point> q =  new LinkedList<>();
        for(int i =0;i<m;i++)
        {
            for(int j =0;j<n;j++)
            {
                if(grid[i][j]==0) q.add(new Point(i,j));
            }
        }
        int steps = 1;
        while(!q.isEmpty())
        {
            int size=q.size(); 
            for(int i=0;i<size;i++)
            {
                Point p =q.poll();
                int x=p.x(), y=p.y();
                for(int[] d : directions)
                {
                    if(x+d[0]<0 || x+d[0]==m || y+d[1]<0 || y+d[1]==n
                    || grid[x+d[0]][y+d[1]]!=2147483647)
                    continue;
                    grid[x+d[0]][y+d[1]]=steps; 
                    q.add(new Point(x+d[0],y+d[1]));
                }
            }
            steps++;
        }
    }
}
