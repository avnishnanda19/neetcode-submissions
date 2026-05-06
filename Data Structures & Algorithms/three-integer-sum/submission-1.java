class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int prevTarget = Integer.MAX_VALUE;

        for(int targetIndex = 0; targetIndex <n; targetIndex++)
        {
            int target = -1*nums[targetIndex];
            int left= targetIndex+1; 
            int right =  n-1;
            if(target!=prevTarget){
            
            int prevLeft=nums[n-1]+1, prevRight=nums[n-1]+1;
            while(left<right)
            {
                int sum = nums[left]+nums[right]; 
                
                if(sum==target)
                {
                    System.out.println(target +" "+left+" "+right);
                     if(prevLeft==nums[n-1]+1 && prevRight==nums[n-1]+1)
                     {
                    
                        Integer[] triplet = new Integer[]{nums[targetIndex], nums[left] ,  nums[right]}; 
                        result.add(Arrays.asList(triplet));
                     }
                     else if(nums[left]!=prevLeft || nums[right]!=prevRight)
                     {
                         Integer[] triplet = new Integer[]{nums[targetIndex], nums[left] ,  nums[right]}; 
                         result.add(Arrays.asList(triplet));
                     }
                     prevLeft= nums[left]; 
                     prevRight= nums[right]; 
                    left++; 
                    right--;
                }
                else if(sum>target)
                {
                    right--; 
                }
                else left++;
            } 
            prevTarget=target;
            }
        }
        return result;
    }
}
