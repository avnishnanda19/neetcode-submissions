class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        //boolean[] canJump = new boolean[n]; 
       // canJump[n-1]=true;
        int goal = n-1;
        for(int i=n-2;i>=0;i--)
        {
            if(i+nums[i]>=goal){
                goal=i;
            }
        }
        return goal==0;
    }
}
