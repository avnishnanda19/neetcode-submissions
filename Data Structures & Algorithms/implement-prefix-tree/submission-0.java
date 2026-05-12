class Trie {
    Trie[] children = new Trie[26];
    boolean isEnd = false;
}
class PrefixTree {
    Trie root;
    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie curr = root;
        for(char c : word.toCharArray())
        {
            int cIndex = c-'a'; 
            if(curr.children[cIndex]==null)
                curr.children[cIndex] = new Trie();
            curr= curr.children[cIndex];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        Trie curr = root;
        for(char c : word.toCharArray())
        {
            int cIndex = c-'a'; 
            if(curr.children[cIndex]!=null)
                curr= curr.children[cIndex];
            else return false;
        }
        if(curr.isEnd) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        Trie curr = root;
        for(char c : prefix.toCharArray())
        {
            int cIndex = c-'a'; 
            if(curr.children[cIndex]!=null)
                curr= curr.children[cIndex];
            else return false;
        }
        return true;
    }
}
