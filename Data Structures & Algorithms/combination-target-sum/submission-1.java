class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        Arrays.sort(nums); 
        dfs(nums, target, 0 , new ArrayDeque<Integer>());

        return result;
    }
    private void dfs(int[] nums, int target, int index, Deque<Integer> stack)
    {
        if(target==0) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for(int i=index;i<nums.length;i++)
        {
            if(nums[i]<=target)
            {
                stack.push(nums[i]);
                dfs(nums, target-nums[i], i , stack);
                stack.pop();
            }
        }
    }
}
