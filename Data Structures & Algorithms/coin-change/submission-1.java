class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp =  new int[amount+1]; 
        Arrays.fill(dp, amount+2);
        dp[0]=0;
        for(int i : coins)
        {
            for(int j=i;j<=amount;j++)
            {
                dp[j]=Math.min(dp[j-i]+1, dp[j]);
            }
        }
        return dp[amount]==amount+2 ? -1 : dp[amount];
    }
}
