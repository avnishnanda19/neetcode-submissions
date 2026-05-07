class Solution {
    public String minWindow(String s, String t) {
        if(t.length()> s.length()) return ""; 
        if(t.equals(s)) return t;

        Map<Character, Integer> tFreqMap = new HashMap<>(); 
        Map<Character, Integer> sFreqMap = new HashMap<>(); 

        for(char c : t.toCharArray())
            tFreqMap.put(c , tFreqMap.getOrDefault(c,0)+1);

       int left=0, right = 0; 
       String minString = s+" ";

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
                String replace=s.substring(left , right);
                if(replace.length()<minString.length())
                    minString=replace;
                char c = s.charAt(left); 
                sFreqMap.put(c , sFreqMap.get(c)-1);
                left++;
            }
            
       }
    //    while(left<right && checkFreqMapMatch(sFreqMap, tFreqMap))
    //         {
    //             char c = s.charAt(left); 
    //             sFreqMap.put(c , sFreqMap.get(c)-1);
    //             left++;
    //         }
    //         String replace=s.substring(left-1 , right);
    //         if(replace.length()<minString.length())
    //          minString=replace;
    //         //System.out.println(">"+ s.substring(left-1, right));
       return minString.equals(s+" ")? "" : minString;


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
