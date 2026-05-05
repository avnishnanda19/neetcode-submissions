class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indicesMap= new HashMap<>(); 

       for(int i=0;i<nums.length;i++)
       {
         if(indicesMap.containsKey(target-nums[i]))
         {
            return new int[]{indicesMap.get(target-nums[i]), i};
         }
         indicesMap.put( nums[i], i );
       }
       return new int[]{-1,-1};
    }
}
