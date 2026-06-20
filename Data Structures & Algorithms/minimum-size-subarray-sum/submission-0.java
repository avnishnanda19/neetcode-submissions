class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0, right =0;
        int minLength  =  nums.length+1;
        int sum =0;
        for(;right<nums.length;right++)
        {
            sum +=nums[right];
            while(sum>=target)
            {
                minLength = Math.min(minLength, right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return minLength==nums.length+1 ? 0 : minLength;
    }
}