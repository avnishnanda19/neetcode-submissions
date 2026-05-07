class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0 , right=0; 
        int n =s.length();

        int[] charCount = new int[26];
        int maxLength=0;

        while(right<n && left<=right)
        {
            
            if((right-left)-getMaxFreq(charCount)<=k){
                char current = s.charAt(right);
                maxLength=Math.max(maxLength, (right-left));
                //System.out.println(left +" "+right+" "+maxLength);
                charCount[current-'A']++;
                right++;
            }
            else{
                while((right-left)-getMaxFreq(charCount)>k){
                    char current = s.charAt(left);
                    charCount[current-'A']--;
                    left++;
                }
            }
        }
        while((right-left)-getMaxFreq(charCount)>k){
                    char current = s.charAt(left);
                    charCount[current-'A']--;
                    left++;
        }
        maxLength=Math.max(maxLength, (right-left));
        return maxLength;

    }
    private int getMaxFreq(int[] charCount)
    {
        int maxFreq=0;
        for(int i :  charCount)
        {
            maxFreq=Math.max(maxFreq, i);
        }

        return maxFreq;
    }
}
