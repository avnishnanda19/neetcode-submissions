class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0; 
        if(n==1) return nums[0];

        return Math.max(robHouse(nums, 0, n-2), robHouse(nums, 1, n-1));

    }
    private int robHouse(int nums[], int start, int end)
    { 
        if((end-start+1)==1) return nums[start];
        int[] rob= new int[end-start+1];
        rob[0]=nums[start];
        rob[1]=Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<=end;i++)
        {
            rob[i-start]=Math.max(nums[i]+rob[i-2-start], rob[i-start-1]);
        }
        return rob[end-start];
    }
}
