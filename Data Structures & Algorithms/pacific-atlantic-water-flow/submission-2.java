class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific =getPacificFlows(heights);
        boolean[][] atlantic =getAtlanticFlows(heights);

        List<List<Integer>> result  =new ArrayList<>(); 
        for(int i=0;i<heights.length;i++)
        {
            for(int j=0;j<heights[0].length;j++)
            {
                if(pacific[i][j] && atlantic[i][j])
                    {
                        List<Integer> out= new ArrayList<>(); 
                        out.add(i); 
                        out.add(j); 
                        result.add(out);
                    }
            }
        }
        return result;
    }
    private boolean[][] getPacificFlows(int[][] heights)
    {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] result =  new boolean[m][n];

        for(int i=0;i<n;i++)
        {
            getWaterFlow(result, heights, 0, i, -1);
        }
        for(int i=0;i<m;i++)
        {
            getWaterFlow(result, heights, i, 0, -1);
        }
        return result;
    }
    private void getWaterFlow(boolean[][] result, int[][] heights, int x, int y, int prev){
        if(x<0 || y<0 || x>=heights.length || y>=heights[0].length || result[x][y]
        || prev>heights[x][y])
         return;
        result[x][y]= true;
        getWaterFlow(result, heights, x+1, y, heights[x][y]);
        getWaterFlow(result, heights, x, y+1, heights[x][y]);
        getWaterFlow(result, heights, x, y-1, heights[x][y]);
        getWaterFlow(result, heights, x-1, y, heights[x][y]);
        
    }
    private boolean[][] getAtlanticFlows(int[][] heights)
    {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] result =  new boolean[m][n];
        for(int i=0;i<n;i++)
        {
            getWaterFlow(result, heights, m-1, i, -1);
        }
        for(int i=0;i<m;i++)
        {
            getWaterFlow(result, heights, i, n-1, -1);
        }
        return result;
    }

}
