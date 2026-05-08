class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>(); 
        List<char[]> board= new ArrayList<>(); 
        initializeBoard(board, n);
        nQueensSolve(board, 0 , n);
        return result;
    }

    private void nQueensSolve(List<char[]> board, int row , int n)
    {
        if(row ==n)
        {
            List<String> strBoard = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                String s = new String(board.get(i)); 
                strBoard.add(s);
            }
            result.add(strBoard);
        return;    
        }
        

        for(int i=0; i<n ;i++)
        {
            if(isSafeQueen(board, row, i, n))
               { 
                board.get(row)[i]='Q';
                nQueensSolve(board, row+1, n);
                board.get(row)[i]='.';
               }
        } 
              
    }
    private boolean isSafeQueen(List<char[]> board, int row , int pos, int n)
    {
        for(int i=0;i<row;i++)
        {
            if(board.get(i)[pos]==('Q'))
            return false;
        }
        for(int i=0;i<pos;i++)
        {
            if(board.get(row)[i]==('Q'))
            return false;
        }
        int i=1;
        while((row-i)>=0 && (pos-i)>=0)
        {
            if(board.get(row-i)[pos-i]==('Q'))
            return false;
            i++;
        }
        i=1;
        while((row-i)>=0 && (pos+i)<n)
        {
            if(board.get(row-i)[pos+i]==('Q'))
            return false;
            i++;
        }
        return true;
    }

    private void initializeBoard(List<char[]> board ,int n){
        
        for(int i=0;i<n;i++)
        {   
            char[] row = new char[n]; 
            for(int j=0;j<n;j++)
            {
                row[j]='.';
            }
            board.add(row);
        } 
    }
}
