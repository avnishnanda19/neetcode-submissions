class Solution {
    int ways =0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return ways;
    }
    private void dfs(int[] nums, int target, int sum , int index)
    {
        if(index==nums.length)
        {
            if(target==sum) ways++;
            return;
        }
        dfs(nums, target, sum+nums[index], index+1);
        dfs(nums, target, sum-nums[index], index+1);
    }
}
