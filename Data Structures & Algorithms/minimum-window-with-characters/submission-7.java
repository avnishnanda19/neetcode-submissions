class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        
        HashMap<Character, Integer> tCharMap= new HashMap<>();
        for(char c : t.toCharArray())
        {
            tCharMap.put(c, tCharMap.getOrDefault(c,0)+1);
        }
        HashMap<Character, Integer> sCharMap= new HashMap<>();
        int length = s.length()+1;
        int left=0 , right =0; 
        int[] b = new int[]{-1,-1};
        for(;right<s.length();right++)
        {
            char c = s.charAt(right);
            if(tCharMap.containsKey(c))
            {
                sCharMap.put(c, sCharMap.getOrDefault(c,0)+1);
            }
            while(isMatch(sCharMap,tCharMap))
            {
                char r = s.charAt(left++);
                if(tCharMap.containsKey(r))
                {
                    sCharMap.put(r, sCharMap.getOrDefault(r,0)-1);
                    if(sCharMap.get(r)==0) sCharMap.remove(r);
                }
                if(right-left<length)
                {
                    length = right-left;
                    b =  new int[]{left-1, right+1};
                }
            }
            
        }
        return length == s.length()+1 ? "" : s.substring(b[0],b[1]);
       
    }
     private boolean isMatch(HashMap<Character, Integer> sCharMap, HashMap<Character, Integer> tCharMap)
        {
            if(sCharMap.size()!=tCharMap.size()) return false;

            for(char k : sCharMap.keySet())
            {
                if(tCharMap.get(k)>sCharMap.get(k)) return false;
            }
            return true;
        }
}
