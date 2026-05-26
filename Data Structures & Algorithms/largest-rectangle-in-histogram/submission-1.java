class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack =  new ArrayDeque<>(); 
        int n =heights.length;
        int[] left = new int[n]; 

        for(int i=0;i<n;i++)
        {
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
                stack.poll();
            if(stack.isEmpty()) left[i]=-1;
            else left[i]=stack.peek();
            stack.push(i);
        }
        stack.clear();

        int[] right = new int[n]; 

        for(int i=n-1;i>=0;i--)
        {
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
                stack.poll();
            if(stack.isEmpty()) right[i]=n;
            else right[i]=stack.peek();
            stack.push(i);
        }
        int maxArea=0;
        for(int i=0;i<n;i++)
        {
            int area = (right[i]-left[i]-1)*heights[i];
            
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;

    }
}
