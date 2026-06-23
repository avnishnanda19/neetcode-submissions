class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp= new boolean[s.length()+1];
        dp[s.length()]=true; 

        for(int i=s.length()-1;i>=0;i--)
        {
            for(String w : wordDict)
            {
                if(w.length()+i>s.length()) continue;
                if(s.substring(i,i+w.length()).equals(w))
                {
                    dp[i]=dp[i+w.length()];
                }
                if(dp[i]) break;
            }
        }
        return dp[0];
    }
}
