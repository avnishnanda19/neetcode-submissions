class Solution {
    public int trap(int[] height) {
        int n =height.length; 
        int[] leftHeight= new int[n];
        int[] rightHeight = new int[n];
        leftHeight[0]=height[0]; 
        rightHeight[n-1]=height[n-1];
        for(int i=1;i<n;i++)
        {
            leftHeight[i]=Math.max(leftHeight[i-1], height[i]);
            rightHeight[n-1-i]=Math.max(rightHeight[n-i], height[n-1-i]);
        }
        int quantity=0;
        for(int i =0;i<n;i++)
        {   
            quantity+=(Math.min(rightHeight[i],leftHeight[i])-height[i]);
        }
        return quantity;
    }
}
