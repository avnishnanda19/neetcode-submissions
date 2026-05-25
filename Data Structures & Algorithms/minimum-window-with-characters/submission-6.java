class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        if(t.equals(s)) return t;
        HashMap<Character, Integer> tFreqMap = new HashMap<>(); 
        for(char c : t.toCharArray())
        {
            tFreqMap.put(c, tFreqMap.getOrDefault(c, 0)+1);
        }

        HashMap<Character, Integer> sFreqMap = new HashMap<>(); 
        int left =0, right = 0;
        int[] boundaries = new int[]{-1,-1}; 
        int minLength =s.length()+1;

        while(right<s.length())
        {
            while(right<s.length() && !isMatch(sFreqMap, tFreqMap))
            {
                sFreqMap.put(s.charAt(right), sFreqMap.getOrDefault(s.charAt(right),0)+1);
                right++;
            }
            
            while(left<=right && isMatch(sFreqMap, tFreqMap))
            {
                if((right-left)<minLength)
                {
                    minLength = right-left;
                    boundaries=new int[]{left, right};
                }
                sFreqMap.put(s.charAt(left), sFreqMap.get(s.charAt(left))-1);
                left++;
            }
        }
        return minLength == s.length()+1 ?  "" : s.substring(boundaries[0], boundaries[1]);
    }
    private boolean  isMatch(HashMap<Character, Integer> sFreqMap, HashMap<Character, Integer> tFreqMap){
        for(char key : tFreqMap.keySet())
        {
            if( !sFreqMap.containsKey(key) || sFreqMap.get(key)<tFreqMap.get(key))
            return false;
        }
        
        return true;
    }
}
