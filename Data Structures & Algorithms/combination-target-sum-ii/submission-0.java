class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>(); 
        if(candidates.length==0) return result;

        Arrays.sort(candidates);

        getCombinationSumArrays(0 , candidates, target, new ArrayDeque<Integer>());

        return result;
    }
    private void getCombinationSumArrays(int index, int[] candidates, int target, Deque<Integer> stack)
    {
        if(target==0)
        {
            result.add(new ArrayList<>(stack));
            return;
        }
        for(int i=index; i <candidates.length && candidates[i]<=target ;i++)
        {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
                stack.push(candidates[i]); 
                getCombinationSumArrays(i+1 , candidates, target-candidates[i],stack);
                stack.pop();
            
        }
    }
}
