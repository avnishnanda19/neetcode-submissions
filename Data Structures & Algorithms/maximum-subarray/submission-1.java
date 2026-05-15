class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length; 
        int[] sum = new int[n]; 
        sum[0]=nums[0]; 
        for(int i=1;i<n;i++)
        {
            sum[i]=Math.max(nums[i],nums[i]+sum[i-1]);
        }
        int maxValue = sum[0];
        for(int i :  sum){
           
            maxValue =  Math.max(i, maxValue);
        }
        return maxValue;
    }
}
