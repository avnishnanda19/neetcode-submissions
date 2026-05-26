class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack =  new ArrayDeque<>(); 
        int n = temperatures.length;
        int[] daysAfter = new int[n];

        for(int i=n-1;i>=0;i--)
        {
            while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i])
                stack.poll();
            if(stack.isEmpty()) daysAfter[i]=0; 
            else {
                
                daysAfter[i]=stack.peek()-i; 
            }
            stack.push(i);
        }
        return daysAfter;
    }
}
