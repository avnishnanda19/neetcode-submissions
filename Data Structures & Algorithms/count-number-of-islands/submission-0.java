record Point(int x, int y){}
class Solution {

    public int numIslands(char[][] grid) {
        int islands = 0 ;

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    Queue<Point> points = new LinkedList<>();
                    points.offer(new Point(i, j)); 
                    grid[i][j]='2';
                    while(!points.isEmpty())
                    {
                        Point p = points.poll();
                        int x = p.x(), y=p.y();

                        if(x-1>=0 && grid[x-1][y]=='1')
                        {
                            grid[x-1][y]='2';
                            points.offer(new Point(x-1, y));
                        } 
                        if(y-1>=0 && grid[x][y-1]=='1')
                        {
                             grid[x][y-1]='2';
                             points.offer(new Point(x, y-1));
                        }
                        if(x+1<grid.length && grid[x+1][y]=='1')
                        {
                             grid[x+1][y]='2';
                             points.offer(new Point(x+1, y));
                        }
                        if(y+1<grid[0].length && grid[x][y+1]=='1')
                        {
                             grid[x][y+1]='2';
                             points.offer(new Point(x, y+1));
                        } 
                    }
                    islands++;
                }
            }
        }
        return islands;
    }
}
