class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i =0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                
                if(board[i][j]==word.charAt(0))
                    if(dfs(i, j, board, word , 0 , visited)) return true;
            }
        }
        return false;
    }
    private boolean dfs(int x , int y, char[][] board, String word, int index, boolean[][] visited)
    {
        
        if(index == word.length())
        return true;
        if( x<0 || y<0 || x>=board.length || y>=board[0].length || visited[x][y] || board[x][y]!=word.charAt(index))
        return false;

        visited[x][y]=true;
        boolean result = dfs(x+1 , y , board, word, index+1, visited) ||
                dfs(x , y+1 , board, word, index+1, visited) ||
                dfs(x-1 , y , board, word, index+1, visited) ||
                dfs(x , y-1 , board, word, index+1, visited) ;
        visited[x][y]=false;
        return result;
    }
}
