class Solution {
    int ways ;
    public int findTargetSumWays(int[] nums, int target) {
        ways=0;
        dfs(nums, target , 0);
        return ways; 
    }

    private void dfs(int[] nums, int target, int index)
    {
        if(index==nums.length)
        {
            if(target==0) {
                ways++;
            }
            return;
        }

        dfs(nums, target-nums[index], index+1);
        dfs(nums, target+nums[index], index+1);
    }
}
