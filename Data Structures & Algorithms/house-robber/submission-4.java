class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1) return nums[0]; 
        if(n==2) return Math.max(nums[0], nums[1]);

        int a = nums[0]; 
        int b = Math.max(nums[0], nums[1]);
        int c=0;
        for(int i=2;i<n;i++)
        {
            c = Math.max(b, a+nums[i]);
            a=b;
            b=c;
        }

        return c;

    }
}
