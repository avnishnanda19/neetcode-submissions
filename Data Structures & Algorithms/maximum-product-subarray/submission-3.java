class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length; 
        int maxProduct = nums[0]; 
        int c1 = nums[0], c2=nums[0]; 

        for(int i=1;i<n;i++)
        {
            int tmp = c1*nums[i]; 
            c1=Math.max(tmp, Math.max(c2*nums[i],nums[i]));
            c2=Math.min(tmp, Math.min(c2*nums[i],nums[i]));
            maxProduct = Math.max(maxProduct , c1);
        }

        return maxProduct;
    }
}
