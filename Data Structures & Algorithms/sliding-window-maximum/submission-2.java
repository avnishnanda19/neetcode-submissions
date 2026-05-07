class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>(); 

        int start=0, i=0; 
        int[] result= new int[nums.length -k+1]; 

        int index =0;
        while(i<nums.length)
        {
            while(!q.isEmpty() && nums[q.getLast()]<nums[i])
                q.removeLast();
            
            q.addLast(i);

            if(q.getFirst()<start)
            q.removeFirst();
            
            if ((i + 1) >= k) {
                result[start++] = nums[q.getFirst()];
            }
            i++;
        }
        return result;
    }
}
