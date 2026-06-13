class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=s1.length()+s2.length()) return false; 
       return  dfs( s1, s2 , s3, 0, 0, 0);
    }
    private boolean dfs(String s1, String s2, String s3, int i1 , int i2, int i3)
    {
        if(i3==s3.length()) return true;
        
        boolean ans = false; 
        if(i1<s1.length() && s3.charAt(i3)==s1.charAt(i1)) ans = ans || dfs(s1,s2,s3,i1+1, i2, i3+1);
        if(i2<s2.length() && s3.charAt(i3)==s2.charAt(i2)) ans = ans || dfs(s1,s2,s3,i1, i2+1, i3+1);
        return ans;
    }
}
