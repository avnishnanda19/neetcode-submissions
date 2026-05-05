class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seqSet =  new HashSet<>(); 
        List<Integer> startPoints = new ArrayList<>();

        for(int i: nums)
        {
            if(!seqSet.contains(i-1)) startPoints.add(i);
            seqSet.add(i); 
            
        }

        int lengthOfSeq=0;
        for(int i : startPoints)
        {   
            System.out.println(i);
            int length=0;
            int startPoint = i;
            while(true)
            {
                if(seqSet.contains(startPoint))
                {
                    length++;
                    startPoint++;
                }
                else break;
            }
            if(lengthOfSeq<length) lengthOfSeq=length;
        }
        return lengthOfSeq;
    }
}
