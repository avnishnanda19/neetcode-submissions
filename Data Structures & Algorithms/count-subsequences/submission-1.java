class Solution {
    // int count=0;
    Integer[][] dp ;
    public int numDistinct(String s, String t) {
        if(t.length()>s.length()) return 0;
        dp=  new Integer[s.length()+1][t.length()+1];
        return dfs(s, t, 0 , 0);
    }
    private int dfs(String s, String t, int i , int j)
    {
        if(j==t.length())
        {
            return 1;
        }
        if(i==s.length())
        {
            return 0;
        }
        if(dp[i][j]!=null) return dp[i][j];

        int result= dfs(s, t, i+1, j);
        if(s.charAt(i)==t.charAt(j))
        {
            result+=dfs(s, t, i+1, j+1);
        }
        return dp[i][j]=result;
    }
}
