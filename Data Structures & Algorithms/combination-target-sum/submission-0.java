class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, target, 0, new ArrayDeque<>() );
        return result;
    }
    public void dfs(int[] nums, int target, int index, Deque<Integer> deque )
    {
        if(target==0)
        {
            result.add(new ArrayList<>(deque));
            return;
        }
        if(index==nums.length || target<0)
        return;
        for(int i=index; i<nums.length;i++)
        {
            if(nums[i]<=target)
            {
                deque.push(nums[i]);
                dfs(nums,target-nums[i],i, deque);
                deque.pop();
            }
            else break;
        }
    }
}
