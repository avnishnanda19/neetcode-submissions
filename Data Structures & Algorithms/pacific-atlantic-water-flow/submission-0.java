record Point(int x , int y){}

class Solution {
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        HashSet<Point> Ppoints = new HashSet<>();
        HashSet<Point> Apoints = new HashSet<>();
        int n = heights.length; 
        int m = heights[0].length;

        for(int i=0;i<m;i++)
        {
            dfs(0, i, Ppoints,heights, heights[0][i]);
            dfs(n-1, i, Apoints,heights, heights[n-1][i]);
        }

        for(int i=0;i<n;i++)
        {
            dfs(i, 0, Ppoints,heights, heights[i][0]);
            dfs(i, m-1, Apoints,heights, heights[i][m-1]);
        }
        List<List<Integer>> result  = new ArrayList<>();
        for(Point i : Ppoints)
        {
            // System.out.println(i.toString());
            if(Apoints.contains(i))
            {
                List<Integer> point = new ArrayList<>(); 
                point.add(i.x()); 
                point.add(i.y());
                result.add(point);
            }
        }
        return result;
    }
    private void dfs(int x , int y , HashSet<Point> points,int[][] heights, int height)
    {
        Point p = new Point(x,y); 
        if(points.contains(p) || x<0 || y<0 || x>=heights.length || y>=heights[0].length 
        || heights[x][y]< height)
        return; 
        //System.out.println(heights[x][y] + " added ");
        points.add(p); 
        dfs(x+1, y, points ,heights, heights[x][y]);
        dfs(x, y+1, points ,heights, heights[x][y]);
        dfs(x-1, y, points ,heights, heights[x][y]);
        dfs(x, y-1, points ,heights, heights[x][y]);
    }
}
