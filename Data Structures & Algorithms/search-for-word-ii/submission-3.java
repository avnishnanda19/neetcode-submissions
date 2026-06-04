class Solution {
    
    class Trie{
        Trie[] chars; 
        boolean isLastWord;
        String word ;
        public Trie()
        {
            chars = new Trie[26]; 
            isLastWord=false;
            word =null;
        }
    }

    List<String> result ;
    boolean[][] visit ;
    Trie head ;

    public List<String> findWords(char[][] board, String[] words) {
        
        int m = board.length; 
        int n = board[0].length; 
        visit = new boolean[m][n];
        result = new ArrayList<>();
        head = new Trie(); 

        for(String w : words)
        {
            addToTrie(w);
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                char ch = board[i][j]; 
                if(head.chars[ch-'a']!=null)
                {
                    dfs(board , i , j , head);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] board, int row, int col , Trie node)
    {
        if(row<0 || col< 0 || row>=board.length || col>=board[0].length
            || visit[row][col] || node.chars[board[row][col]-'a']==null)
            {
                return ;
            }

        visit[row][col]=true;
        node= node.chars[board[row][col]-'a'];

        if(node.isLastWord)
        {
            result.add(node.word);
            node.isLastWord = false;
            node.word=null;
        }

        dfs(board , row+1 , col , node);
        dfs(board , row , col+1 , node);
        dfs(board , row , col-1 , node);
        dfs(board , row-1 , col , node);

        visit[row][col]=false;

    }
    private void addToTrie(String word)
    {
        Trie node =head;
        for(char c : word.toCharArray())
        {
            if(node.chars[c-'a']==null)
            {
                node.chars[c-'a']= new Trie();
            }
            node = node.chars[c-'a'];
        }
        node.isLastWord =true;
        node.word = word;
    }
}
