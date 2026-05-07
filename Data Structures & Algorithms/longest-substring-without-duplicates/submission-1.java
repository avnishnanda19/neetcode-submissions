class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charPosMap =  new HashMap<>();

        int start=0, right=0;
        int maxLength=0;
        for(;right<s.length();right++)
        {
            char current = s.charAt(right);
            if(charPosMap.containsKey(current))
            {
                maxLength=Math.max(maxLength, (right-start));
                start=Math.max(start, charPosMap.get(current)+1);
            }
            charPosMap.put(current, right);
        }
        maxLength=Math.max(maxLength, (right-start));
        return maxLength;
    }
}
