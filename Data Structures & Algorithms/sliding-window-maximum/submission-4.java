class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> maxQueue = new ArrayDeque<>(); 

        List<Integer> maxArr = new ArrayList<>();
        for(int i =0;i<k;i++)
        {
            while(!maxQueue.isEmpty() && maxQueue.getLast()<nums[i])
                maxQueue.pollLast();
            maxQueue.addLast(nums[i]);

        }
        for(int i=0;i+k<nums.length;i++)
        {
            maxArr.add(maxQueue.getFirst());

            if(nums[i]==maxQueue.getFirst())
            {
                maxQueue.pollFirst();
            }

            while(!maxQueue.isEmpty() && maxQueue.getLast()<nums[i+k])
                maxQueue.pollLast();
            maxQueue.addLast(nums[i+k]);
            
        }
        maxArr.add(maxQueue.getFirst());
        return maxArr.stream().mapToInt(Integer::intValue).toArray();
    }
}
