class Solution {
    public int rob(int[] nums) {
        int n =  nums.length; 
        if(n==0) return 0;
        if(n==1) return nums[0]; 
        if(n==2) return Math.max(nums[0],nums[1]);

        int[] robFirst = new int[n-1];
        int[] robLast =  new int[n-1];

        robFirst[0] = nums[0]; 
        robFirst[1] = Math.max(nums[0], nums[1]); 
        for(int i=2;i<n-1;i++)
        {
            robFirst[i]=Math.max(robFirst[i-2]+nums[i], robFirst[i-1]);
        }

        robLast[0] = nums[1]; 
        robLast[1] = Math.max(nums[1], nums[2]); 
        for(int i=3;i<=n-1;i++)
        {
            robLast[i-1]=Math.max(robLast[i-3]+nums[i], robLast[i-2]);
        }

        return Math.max(robLast[n-2], robFirst[n-2]);
    }
}
