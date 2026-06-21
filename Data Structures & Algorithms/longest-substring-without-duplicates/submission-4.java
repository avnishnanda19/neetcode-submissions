class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null ||s.length()==0) return 0;
        int left =0, right =0;
        HashMap<Character, Integer> indexMap = new HashMap<>(); 
        int maxLength=1;
        for(;right<s.length();right++)
        {
            char c = s.charAt(right);
            if(indexMap.containsKey(c))
            {
                maxLength = Math.max(maxLength, right-left);
                left =Math.max(left, indexMap.get(c)+1);
            }
            indexMap.put(c, right); 
        }
        maxLength = Math.max(maxLength, right-left);
        
        // maxLength = Math.max(maxLength, right-left-1);
        return maxLength;
    }
}
