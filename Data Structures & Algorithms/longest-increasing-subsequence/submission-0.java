class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[]lis = new int[n];
        Arrays.fill(lis, 1);
        for(int i=0;i<n;i++)
        {
            for(int j =i+1; j<n;j++)
            {
                if(nums[j]>nums[i])
                {
                    lis[j]=Math.max(lis[j], lis[i]+1);
                }
            }
        } 
        
        return Arrays.stream(lis).max().getAsInt();
    }
}
