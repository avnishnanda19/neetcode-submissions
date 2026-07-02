class Solution {
    Integer[][] dp ;
    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m =matrix.length; 
        int n =matrix[0].length;
        dp=new Integer[m][n];
        int maxPath=1;
        for(int i =0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {   
                if(dp[i][j]==null)
                    dfs(matrix , i, j);
                maxPath= Math.max(maxPath, dp[i][j]);
            }
        }
        
        return maxPath;
    }
    private int dfs(int[][] matrix, int x, int y)
    {
        int m =matrix.length; 
        int n =matrix[0].length;
        
        int val=1;
        for(int[] d : dir)
        {
            if(x+d[0]<0 || y+d[1]<0 || x+d[0]>=m || y+d[1]>=n ||
            matrix[x+d[0]][y+d[1]]>=matrix[x][y])
            continue;
            if(dp[x+d[0]][y+d[1]]!=null)
                val=Math.max(val, 1+dp[x+d[0]][y+d[1]]);
            else val=Math.max(val, 1+dfs(matrix , x+d[0], y+d[1]));
        }
        return dp[x][y]=val;
    }
}
