class Solution {
    List<List<String>> result ;
    boolean[] cols ;
    public List<List<String>> solveNQueens(int n) {
       result = new ArrayList<>(); 
       cols= new boolean[n];
       char[][] board = new char[n][n];
       for(int i=0;i<n;i++)
       {
        Arrays.fill(board[i],'.');
       }
    //    for(int i =0;i<n;i++)
    //    {
            nQueens(board, 0);
    //    }
     
        return result; 
    }

    private void nQueens(char[][] board, int row )
    {
        if(row==board.length)
        {
            System.out.println("found");
            List<String> out = new ArrayList<>(); 
            for(int i=0;i<row;i++)
            {
                out.add(new String(board[i]));
            }
            result.add(out);
            return;
        }
        for(int index=0;index<board.length;index++)
        {
            if( !cols[index] && possiblePlace( board, row, index))
            {
                board[row][index]='Q';
                cols[index]=true;

                nQueens(board, row+1);

                board[row][index]='.';
                cols[index]=false;
            }
        }
    }

    private boolean possiblePlace(char[][] board, int row , int index)
    {
        int x= row, y=index;
        while(x>=0 && y>=0)
        {
            if(board[x--][y--]=='Q') return false;
        }
        x= row; y=index;
        while(x>=0 && y<board.length)
        {
            if(board[x--][y++]=='Q') return false;
        }
        return true;
    }
}
