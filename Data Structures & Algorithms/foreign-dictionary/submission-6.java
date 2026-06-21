class Solution {
    public String foreignDictionary(String[] words) {
      HashMap<Character, Set<Character>> adjMatrix  = new HashMap<>();
      HashMap<Character, Integer> inOrder = new HashMap<>(); 

      for(String w :  words)
      {
        for(char c : w.toCharArray())
        {
            adjMatrix.putIfAbsent(c, new HashSet<>());
            inOrder.putIfAbsent(c, 0);
        }
      }

      for(int i=1;i<words.length;i++)
      {
        String prev = words[i-1], curr= words[i]; 
        int prevLen = prev.length(), currLen = curr.length();
        int minLen = Math.min(prevLen, currLen);
        if(prev.substring(0,minLen).equals(curr.substring(0,minLen))
            && prevLen>currLen) return "";
        for(int j =0;j<minLen;j++)
        {
            char pc = prev.charAt(j);
            char cc = curr.charAt(j); 
            if(pc!=cc)
            {   
                if(!adjMatrix.get(pc).contains(cc)){
                adjMatrix.compute(pc, (key, val)-> val==null ? new HashSet<>() : val).add(cc);
                inOrder.put(cc, inOrder.getOrDefault(cc,0)+1);
                }
                break;
            }
            
        }
      }

      Queue<Character> q = new LinkedList<>();
      for(char i : inOrder.keySet())
      {
        if(inOrder.get(i)==0) q.add(i);
      }

      StringBuilder str =  new StringBuilder(); 
      while(!q.isEmpty())
      {
         char p = q.poll(); 
         str.append(p); 
         for(char c : adjMatrix.getOrDefault(p, Collections.emptySet()))
         {
            if(inOrder.get(c)==0) continue;
            inOrder.put(c, inOrder.get(c)-1); 
            if(inOrder.get(c)==0)
            {
                q.add(c);
            }
         }
      }
      if(str.length()!=inOrder.size()) return "";
      return str.toString();
    }
}
