class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> lastIndex = new HashMap<>(); 
        
        for(int i =0;i<s.length();i++)
        {
            lastIndex.put(s.charAt(i), i); 
        }

        List<Integer> result = new ArrayList<>();
        int far= 0;
        int left =0;
        for(int i=0;i<s.length();i++)
        {
            far =Math.max(lastIndex.get(s.charAt(i)), far);
            if(far==i)
            {
                result.add(i-left+1);
                left =i+1;
            }
        }
        return result;

    }
}
