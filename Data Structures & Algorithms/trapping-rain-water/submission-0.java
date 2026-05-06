class Solution {
    public int trap(int[] height) {
        int n=height.length;

        int[] leftHeight = new int[n];
        leftHeight[0]=height[0];
        int[] rightHeight = new int[n];
        rightHeight[n-1]=height[n-1]; 

        for(int i=1;i<n;i++)
        {
            leftHeight[i]=Math.max( leftHeight[i-1], height[i]);
        }
        for(int i=n-2;i>=0;i--)
        {
            rightHeight[i]=Math.max( rightHeight[i+1], height[i]);
        }

        int water=0;
        for(int i=0;i<n;i++)
        {
            int heightToFill=Math.min(rightHeight[i], leftHeight[i])-height[i];
            water+=heightToFill;
        }
        return water;
        
    }
}
