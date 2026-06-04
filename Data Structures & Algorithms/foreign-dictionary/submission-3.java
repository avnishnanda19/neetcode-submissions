class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> adjMatrix = new HashMap<>(); 
      Map<Character, Integer> indegree= new HashMap<>(); 

      for(String w :  words)
      {
        for(char c : w.toCharArray())
        {
            adjMatrix.putIfAbsent(c, new HashSet<>());
            indegree.putIfAbsent(c, 0);
        }
      }

      for(int i= 1;i<words.length;i++)
      {
        String w1 = words[i-1]; 
        String w2 = words[i]; 

        int minLength= Math.min(w1.length(), w2.length()); 
        if(w1.length()>w2.length() && w1.substring(0,minLength).equals(w2))
            return "";
        
        for(int j=0;j<minLength;j++)
        {
            if(w1.charAt(j)!=w2.charAt(j))
            {
                if(!adjMatrix.get(w1.charAt(j)).contains(w2.charAt(j)))
                {
                    adjMatrix.get(w1.charAt(j)).add(w2.charAt(j));
                    indegree.put(w2.charAt(j), indegree.get(w2.charAt(j))+1);
                }
                break;
            }
        }
      }

      Queue<Character> q = new LinkedList<>();
        for(char c : indegree.keySet())
        {
            if(indegree.get(c)==0) q.add(c);
        }

        StringBuilder str = new StringBuilder(); 
        while(!q.isEmpty())
        {
            char ch = q.poll(); 
            str.append(ch); 
            Set<Character> adj = adjMatrix.get(ch);
            for( char c : adj)
            {   
                indegree.put(c, indegree.get(c)-1);
                if(indegree.get(c)==0) q.add(c);
            }
        }

        if (str.length() != indegree.size()) {
            return "";
        }
        return str.toString();
    }
}
