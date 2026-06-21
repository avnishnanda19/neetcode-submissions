class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); 
        for(int i=0;i<nums.length;i++)
        {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target =  -1*nums[i]; 
            int left = i+1, right =  nums.length-1;
            
            while(left<right)
            {
                if(nums[left]+nums[right]==target)
                   {
                    List<Integer> out = new ArrayList<>(); 
                    out.add(nums[i]);
                    out.add(nums[left]);
                    out.add(nums[right]);
                    result.add(out);
                    right--; 
                    left++;
                    while(left<=right && nums[left]==nums[left-1]) left++;
                    while(left<=right && nums[right]==nums[right+1]) right--;
                   } 
                else if(nums[left]+nums[right]>target)
                    right--; 
                else left++;
            }
        }
        return result;
    }
}
