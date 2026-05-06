class Solution {
    class Node{
        int height;
        int position;
        public Node(int height , int position)
        {
            this.height = height; 
            this.position =  position;
        }
        public Node(){}
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length; 

        Deque<Node> backStack = new ArrayDeque<>(); 
        int[] right = new int[n];
        Deque<Node> fStack = new ArrayDeque<>(); 
        int[] left = new int[n]; 

        for(int i=n-1;i>=0;i--)
        {
            while(!backStack.isEmpty() && backStack.peek().height>=heights[i])
                backStack.pop(); 
            if(backStack.isEmpty())
                right[i]=n;
            else {
                right[i]=backStack.peek().position;
            }
            backStack.push(new Node(heights[i],i));
        }
        backStack.clear();
        for(int i=0;i<n;i++)
        {
            while(!backStack.isEmpty() && backStack.peek().height>=heights[i])
                backStack.pop(); 
            if(backStack.isEmpty())
                left[i]=0;
            else {
                left[i]=backStack.peek().position+1;
            }
            backStack.push(new Node(heights[i],i));
        }
        int maxArea= 0;
        for(int i=0;i<n;i++)
        {
            int area=heights[i]*(right[i]-left[i]);
            maxArea=Math.max(area,maxArea);
        }
        
        return maxArea;

    }
    
}
