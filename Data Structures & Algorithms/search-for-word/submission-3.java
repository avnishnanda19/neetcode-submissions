class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                   if(dfs(board, word, i, j , 0)) return true;
            }
        } 
        return false ;
    }
    private boolean dfs(char[][] board, String word, int x , int y  , int index)
    {
        if(index== word.length()) return true;
        if(x<0 || y<0 || x==board.length || y == board[0].length 
        || visited[x][y] || board[x][y]!=word.charAt(index) )
            return false;
        boolean result =false;
        visited[x][y] = true;
        result = result || dfs(board, word, x+1, y , index+1)
         || dfs(board, word, x, y+1 , index+1)
         || dfs(board, word, x-1, y , index+1)
         || dfs(board, word, x, y-1 , index+1);
        visited[x][y] = false;

        return result;
    }
}
