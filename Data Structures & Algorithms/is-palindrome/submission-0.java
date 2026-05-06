class Solution {
    public boolean isPalindrome(String s) {

        int left= 0;
        int right= s.length()-1;
        s=s.toLowerCase();

        while(left<=right)
        {
            if(!(Character.isLetter(s.charAt(left)) || Character.isDigit(s.charAt(left))))
            {
                left++;
                continue;
            }
            if(!(Character.isLetter(s.charAt(right)) || Character.isDigit(s.charAt(right))))
            {
                right--;
                continue;
            }
            if(s.charAt(left)==s.charAt(right))
            {
                left++; right--;
            }
            else  return false ;
        }
        return true;
    }
}
