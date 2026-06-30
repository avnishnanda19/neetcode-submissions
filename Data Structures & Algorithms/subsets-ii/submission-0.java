class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>(); 
        Arrays.sort(nums);
        for(int i=0;i<=nums.length;i++)
        {
            subsets(nums, i ,0, new ArrayList<>());
        }
        return result;
    }

    private void subsets(int[] nums, int size, int index, List<Integer> out)
    {
        if(out.size()==size)
        {
            result.add(new ArrayList<>(out));
            return;
        }
        for(int i=index;i<nums.length;i++)
        {
            if(i==index || nums[i]!=nums[i-1])
            {
                out.add(nums[i]);
                subsets(nums, size , i+1 , out);
                out.remove(out.size()-1);
            }
        }
    }
}
