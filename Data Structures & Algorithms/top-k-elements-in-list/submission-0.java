class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>(); 
        
        int maxFreq= 0;
        for(int i : nums)
        {
            freqMap.put(i, freqMap.getOrDefault(i,0)+1);
            maxFreq=Math.max(maxFreq,freqMap.get(i)); 
        }

        List[] freqElements =  new ArrayList[maxFreq+1];
        for(int i : freqMap.keySet())
        {
            int freq= freqMap.get(i);
            if(freqElements[freq]==null)
                freqElements[freq]=new ArrayList<Integer>();
            freqElements[freq].add(i);
        }
        int index=0;
        for(int i =maxFreq;i>=0;i--)
        {
            if(index==k)
            break;
            if(freqElements[i]==null) continue; 
            for(int j : new ArrayList<Integer>(freqElements[i]))
                if(index==k) break;
                else result[index++]=j;
        }
        return result;
    }
}
