class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length; 
        List<Integer> dp=  new ArrayList<>(); 
        dp.add(nums[0]); 

        int lis=1; 
        for(int i=1 ; i<nums.length;i++)
        {
            if(dp.get(dp.size()-1) < nums[i])
            {
                dp.add(nums[i]); 
                lis++;
                continue;
            }

            int indx = binarySearch(dp, nums[i]);
            if(indx<0)  indx=-indx -1;
            dp.set(indx,nums[i]);
        }


        return lis; 

    }

    private int binarySearch(List<Integer> dp, int num)
    {
        int left=0, right= dp.size()-1; 
        int ans =-1;
        while(left<=right)
        {
            int mid = (left+right)/2; 
            if(dp.get(mid)>=num) {
                ans =mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
    
}
