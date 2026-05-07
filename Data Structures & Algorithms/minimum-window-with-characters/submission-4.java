class Solution {
    public String minWindow(String s, String t) {
        if(t.length()> s.length()) return ""; 
        if(t.equals(s)) return t;

        Map<Character, Integer> tFreqMap = new HashMap<>(); 
        Map<Character, Integer> sFreqMap = new HashMap<>(); 

        for(char c : t.toCharArray())
            tFreqMap.put(c , tFreqMap.getOrDefault(c,0)+1);

       int left=0, right = 0; 
       int minStringLength = s.length()+1;
       int[] boundaries = new int[]{-1,-1};

       while(right<s.length())
       {
            while(right<s.length() && !checkFreqMapMatch(sFreqMap, tFreqMap))
            {
                char c = s.charAt(right); 
                sFreqMap.put(c , sFreqMap.getOrDefault(c,0)+1);
                right++;
            }
            while(left<=right && checkFreqMapMatch(sFreqMap, tFreqMap))
            {
                if((right-left)<minStringLength)
                {
                    minStringLength = right-left;
                    boundaries=new int[]{left, right};
                }
                char c = s.charAt(left); 
                sFreqMap.put(c , sFreqMap.get(c)-1);
                left++;
            }
            
       }
       return minStringLength==(s.length()+1) ? "" : s.substring(boundaries[0], boundaries[1]);
    }
    private boolean checkFreqMapMatch(Map<Character, Integer> sFreqMap , Map<Character, Integer> tFreqMap){
        for(char c : tFreqMap.keySet())
        {
            if(!sFreqMap.containsKey(c)) return false; 
            if(sFreqMap.get(c)<tFreqMap.get(c)) return false;
        }
        return true;
    }
}
