class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1;
        int right =1;
        for(int i : piles)
        {
            right =Math.max(right, i); 
        }

        while(left<right)
        {
            int mid =left+(right-left)/2; 
            int time = calculateTimeToEat( piles, mid);
            if(time<=h)
            {
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return right;
    }

    private int calculateTimeToEat(int[] piles, int q)
    {
        int time = 0;
        for(int i : piles)
        {
           if(i%q!=0)
            time+=1;
            time+=i/q;
        }
        return time;
    }
}
