class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int maxArea = 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    int area =0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i,j});
                    grid[i][j]=0;
                    while(!queue.isEmpty())
                    {
                        int size = queue.size();
                        for(int k=0;k<size;k++)
                        {
                            area++;
                            int[] pollPoint = queue.poll();
                            int x =pollPoint[0];
                            int y =pollPoint[1];
                            
                            for(int[] dir : directions)
                            {
                                if(x+dir[0]>=0 && x+dir[0]<grid.length &&
                                    y+dir[1]>=0 && y+dir[1]<grid[0].length &&
                                    grid[x+dir[0]][y+dir[1]]==1)
                                    {
                                        grid[x+dir[0]][y+dir[1]]=0;
                                        queue.add(new int[]{x+dir[0],y+dir[1]});
                                    }
                            }
                        }
                    }
                    maxArea= Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
}
