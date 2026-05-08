class Solution {
    int minCoins ;
    public int coinChange(int[] coins, int amount) {
        int[] coinsCount = new int[amount+1]; 
        Arrays.fill(coinsCount, amount+1); 
        coinsCount[0]=0;
        for(int i=1;i<=amount;i++)
        {
            for(int j=0;j<coins.length;j++)
            {
                if(coins[j]<=i)
                {
                    coinsCount[i] =Math.min(coinsCount[i],coinsCount[i-coins[j]]+1);
                }
            }

        }
        return coinsCount[amount]>amount ? -1 :  coinsCount[amount];
    } 
}
