class Solution {
    public void solve(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<n;i++)
        {
            if(board[0][i]=='O')
            {
                updateAllNonSurrounded(board , 0 , i);
            }
            if(board[m-1][i]=='O')
            {
                updateAllNonSurrounded(board , m-1 , i);
            }
        }
        for(int i=1;i<m-1;i++)
        {
            if(board[i][0]=='O')
            {
                updateAllNonSurrounded(board , i , 0);
            }
            if(board[i][n-1]=='O')
            {
                updateAllNonSurrounded(board , i , n-1);
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O') board[i][j]='X'; 
                if(board[i][j]=='T') board[i][j]='O'; 
            }
        }
    }

    public void updateAllNonSurrounded(char[][] board , int i , int j)
    {
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> q = new LinkedList<>(); 
        q.add(new int[]{i,j});
        board[i][j]='T';

        while(!q.isEmpty())
        {
            int[] pollPoint = q.poll();
            int x = pollPoint[0];
            int y = pollPoint[1];

            for(int[] d : directions)
            {
                if(x+d[0]>=0 && x+d[0]<m &&
                   y+d[1]>=0 && y+d[1]<n && 
                   board[x+d[0]][y+d[1]]=='O')
                   {
                        board[x+d[0]][y+d[1]]='T';
                        q.add(new int[]{x+d[0],y+d[1]});
                   }
            }
        }
    }
}
