class TrieNode {

    TrieNode[] children;
    boolean word;

    public TrieNode() {
        children = new TrieNode[26];
        word = false;
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root= new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray())
        {
            int cIndex =  c-'a';
            if(curr.children[cIndex]==null)
                curr.children[cIndex] = new TrieNode();
            curr=curr.children[cIndex];
        }
        curr.word=true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        return dfs(word , 0, curr);
    }
    public boolean dfs(String word, int index , TrieNode curr)
    {
        if(index==word.length()){
            return curr.word; 
        } 
        if(word.charAt(index)!='.')
        {
            int cIndex = word.charAt(index)-'a';
            if(curr.children[cIndex]==null) return false; 
            return dfs(word, index+1, curr.children[cIndex]);
        }
        else{
            boolean result = false;
            for(TrieNode trie : curr.children)
            {
                if(trie!=null)
                {
                    result= result || dfs(word, index+1, trie);
                }
            }
            return result;
        }
    }
}
