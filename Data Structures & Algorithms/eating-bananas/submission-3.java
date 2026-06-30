class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min=1, max=piles[0]; 
        for(int i : piles)
        {
            min=Math.min(min, i); 
            max=Math.max(max, i); 
        }

        while(min<max)
        {
            int mid = min+(max-min)/2;
            if(possibleEat(piles, mid , h))
            {
               max=mid;
            }
            else min=mid+1;
        }
        return min;
    }
    private boolean possibleEat(int[] piles, int k, int h)
    {
        int count=0; 
        for(int i : piles)
        {
            count+=(i/k); 
            if(i%k!=0) count++;
        }
        return count<=h;
    }
}
