class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> charLastIndex = new HashMap<>(); 

        for(int i =0;i<s.length();i++)
        {
            charLastIndex.put(s.charAt(i),i);
        }
        List<Integer> result = new ArrayList<>();

        int size=0, end=0;
        for(int i =0;i<s.length();i++)
        {
            char c = s.charAt(i);
            end  = Math.max(end, charLastIndex.get(c));
            size++;
            if(i==end)
            {
                result.add(size); 
                size=0;
            }
        }
        return result;
    }
}
