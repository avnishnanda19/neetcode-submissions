class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int num : nums)
        {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> freqOrder = new PriorityQueue<>((a,b)->Integer.compare(freqMap.get(a),freqMap.get(b)));

        for(int num  : freqMap.keySet())
        {
            freqOrder.offer(num); 
            if(freqOrder.size()>k) freqOrder.poll();
        }

        int[] topK = new int[k]; 
        int topKIndex=0;
        while(!freqOrder.isEmpty())
        {
            topK[topKIndex++]= freqOrder.poll();
        }
        return topK;
    }
}
