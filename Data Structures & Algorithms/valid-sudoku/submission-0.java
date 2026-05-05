class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean rowCheck= checkRows(board); 
        boolean colCheck= checkCols(board);
        boolean boxCheck= checkBoxes(board);
        return rowCheck && colCheck && boxCheck;
    }

    private boolean checkRows(char[][] board){
        for(int i=0;i<9;i++)
        {
            Set<Character> digitSet= new HashSet<>();
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.') continue;
                if(digitSet.contains(board[i][j])) return false;
                digitSet.add(board[i][j]);
            }
        }
        return true;
    }
    private boolean checkCols(char[][] board){
        for(int i=0;i<9;i++)
        {
            Set<Character> digitSet= new HashSet<>();
            for(int j=0;j<9;j++)
            {
                if(board[j][i]=='.') continue;
                if(digitSet.contains(board[j][i])) return false;
                digitSet.add(board[j][i]);
            }
        }
        return true;
    }
    private boolean checkBoxes(char[][] board){
        
        for(int k=0;k<9;k++){
            Set<Character> digitSet= new HashSet<>();
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    int r = (k / 3) * 3 + i;
                    int c = (k % 3) * 3 + j; 
                    if(board[r][c]=='.') continue;
                    if(digitSet.contains(board[r][c])) return false;
                    digitSet.add(board[r][c]);
                }
            }
        }
        return true;
    }
}
