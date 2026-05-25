class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> maxQueue = new ArrayDeque<>(); 

        List<Integer> maxArr = new ArrayList<>();
        for(int i =0;i<k;i++)
        {
            addToMaxQueue(nums[i], maxQueue);
        }
        for(int i=0;i+k<nums.length;i++)
        {
            maxArr.add(maxQueue.getFirst());

            if(nums[i]==maxQueue.getFirst())
            {
                maxQueue.pollFirst();
            }
            addToMaxQueue(nums[i+k], maxQueue);
        }
        maxArr.add(maxQueue.getFirst());
        return maxArr.stream().mapToInt(Integer::intValue).toArray();
    }
    private void addToMaxQueue(int num, Deque<Integer> maxQueue)
    {
        while(!maxQueue.isEmpty() && maxQueue.getLast()<num)
                maxQueue.pollLast();
            maxQueue.addLast(num);
    }
}
