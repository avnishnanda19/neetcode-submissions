class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1) return nums[0]; 
        if(n==1) return Math.max(nums[0], nums[1]);

        int[] rob = new int[n];
        rob[0]=nums[0]; 
        rob[1]=Math.max(nums[0], nums[1]);
        for(int i=2;i<n;i++)
        {
            rob[i]=Math.max(rob[i-2]+nums[i], rob[i-1]);
        }

        return rob[n-1];

    }
}
