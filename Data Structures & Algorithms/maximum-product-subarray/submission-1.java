class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length; 
        int curMax =1 , curMin =1 ; 
        int result = nums[0];

        for(int i=0;i<n;i++)
        {
            int tmp = curMax*nums[i]; 
            curMax = Math.max(curMax*nums[i], Math.max(curMin*nums[i], nums[i]));
            curMin = Math.min(tmp, Math.min(curMin*nums[i], nums[i]));
            result = Math.max(result, curMax);
        }
        return result;

    }
}
