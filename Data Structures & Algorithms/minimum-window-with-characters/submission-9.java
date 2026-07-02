class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";

        Map<Character, Integer> tMap= new HashMap<>(); 
        for(char c: t.toCharArray())
        {
            tMap.put(c, tMap.getOrDefault(c,0)+1);
        }

        Map<Character, Integer> sMap= new HashMap<>();
        int window = s.length()+1; 
        int[] boundary=  new int[]{-1,-1};

        int left=0; 
        int formed=0;
        for(int right=0;right<s.length();right++)
        {
            char c = s.charAt(right); 
            if(tMap.containsKey(c))
            {
                sMap.put(c, sMap.getOrDefault(c,0)+1);
                if(sMap.get(c).intValue()== tMap.get(c).intValue())
                {
                    formed++;
                }
            }
            while(left<=right && formed==tMap.size())
            {
                if(right-left+1<window)
                {
                    window = right-left+1;
                    boundary=  new int[]{left,right+1};
                }
                char r = s.charAt(left++);
                if(tMap.containsKey(r))
                {
                    sMap.put(r, sMap.getOrDefault(r,0)-1);
                    if(sMap.get(r).intValue()<tMap.get(r).intValue())
                    {
                        formed--;
                    }
                }
            }
        }
        if(window == s.length()+1) return "";
        return s.substring(boundary[0], boundary[1]); 
    }
}
