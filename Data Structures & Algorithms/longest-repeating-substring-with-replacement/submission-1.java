class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> sMap = new HashMap<>(); 
        int result =0; 
        int left=0, right=0, maxFreq =0; 

        for(;right<s.length();right++)
        {
            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c,0)+1);

            maxFreq = Math.max(maxFreq, sMap.get(c));

            while(right-left+1-maxFreq > k)
            {
                char r = s.charAt(left++);
                sMap.put(r, sMap.get(r)-1);
            }
            result = Math.max(result, right-left+1);
        }
        return result;
    }
}
