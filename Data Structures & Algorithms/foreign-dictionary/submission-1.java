class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>>  adjMatrix = new HashMap<>(); 
      Map<Character, Integer> indegreeMap = new HashMap<>(); 
      
      for(String w: words)
      {
        for(char c : w.toCharArray())
        {
            adjMatrix.put(c, new HashSet<>()); 
            indegreeMap.put(c, 0); 
        }
      }

     for(int i =0;i<words.length-1;i++)
     {
        String w1 = words[i]; 
        String w2 = words[i+1];
        int minLen = Math.min(w1.length(), w2.length()); 

        if( w1.length()>w2.length() && w2.equals(w1.substring(0,minLen)))
        return "";            

        for(int j =0;j<minLen;j++)
        {
            if(w1.charAt(j)!= w2.charAt(j))
            {
                if(!adjMatrix.get(w1.charAt(j)).contains(w2.charAt(j)))
                {
                    adjMatrix.get(w1.charAt(j)).add(w2.charAt(j));
                    indegreeMap.put(w2.charAt(j), indegreeMap.get(w2.charAt(j))+1);
                }
                break; 
            }
        }
    }

        Queue<Character> q = new LinkedList<>();
        for(char c : indegreeMap.keySet())
        {
            if(indegreeMap.get(c)==0) q.add(c);
        }

        StringBuilder str = new StringBuilder(); 
        while(!q.isEmpty())
        {
            char ch = q.poll(); 
            str.append(ch); 
            Set<Character> adj = adjMatrix.get(ch);
            for( char c : adj)
            {   
                indegreeMap.put(c, indegreeMap.get(c)-1);
                if(indegreeMap.get(c)==0) q.add(c);
            }
        }
        if (str.length() != indegreeMap.size()) {
            return "";
        }
        return str.toString();
     }
        
}

