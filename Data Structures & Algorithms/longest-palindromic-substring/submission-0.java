class Solution {
    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        int maxLength= 0;
        for(int i=0;i<s.length();i++)
        {
            String s1 = expandString(s, i,i); 
            String s2 = expandString(s, i,i+1);
            if(s1.length()>longestPalindrome.length())
            {
                longestPalindrome=s1;
                maxLength= s1.length();
            }
            if(s2.length()>longestPalindrome.length())
            {
                longestPalindrome=s2;
                maxLength= s2.length();
            }
        }
        return longestPalindrome;
    }
    private String expandString(String s , int left, int right)
    {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}
