class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int left=0;
        int right=n-1;

        int maxWater=0;
        while(left<=right)
        {
            int waterLevel = Math.min(heights[left], heights[right]); 
            int water = waterLevel*(right-left);
            if(heights[left]>heights[right])
            {
                right--;
            }
            else{
                left++;
            }
            //System.out.println(water);
            maxWater=Math.max(maxWater, water);
        }
        return maxWater;
    }
}
