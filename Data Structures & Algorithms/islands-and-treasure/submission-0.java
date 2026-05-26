class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] directions =  new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        int m = grid.length; 
        int n = grid[0].length;

        for(int i=0;i<m;i++)
        {
            for(int j =0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    Queue<int[]> positions = new LinkedList<>();
                    positions.add(new int[]{i, j});
                    int d=0;
                    while(!positions.isEmpty())
                    {
                        int length = positions.size();
                       // System.out.println(length+" "+d);
                        for(int k =0;k<length;k++)
                        {
                            int[] position = positions.poll();
                            int x = position[0], y = position[1];
                            if(grid[x][y]<d)
                            continue;
                            grid[x][y]=d;
                            for(int[] dir : directions)
                            {
                                if(x+dir[0]>=0 && x+dir[0]<m 
                                    && y+dir[1]>=0 && y+dir[1]<n && grid[x+dir[0]][y+dir[1]]!=-1)
                                    {
                                        positions.add(new int[]{x+dir[0],y+dir[1]});
                                    }
                            }
                        }
                        d++;
                    }
                }
            }
        }
    }
}
