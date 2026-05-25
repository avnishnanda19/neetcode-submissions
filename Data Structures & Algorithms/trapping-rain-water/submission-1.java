class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftHeights = new int[n];
        int[] rightHeights = new int[n];

        leftHeights[0]= height[0]; 
        rightHeights[n-1]= height[n-1]; 
        for(int i=1;i<n;i++)
        {
            leftHeights[i] = Math.max(leftHeights[i-1], height[i]);
            rightHeights[n-1-i] = Math.max(rightHeights[n-i], height[n-1-i]);
        }

        int quantity =0;
        for(int i=0;i<n;i++)
        {
            quantity+=(Math.min(leftHeights[i],rightHeights[i])-height[i]);
        }

        return quantity;
    }
}
