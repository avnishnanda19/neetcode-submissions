class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        if(s1.length()==0) return true;

        int[] s1Freq= new int[26];
        calcStrFreq(s1Freq, 0, s1.length()-1, s1);

        int[] s2Freq = new int[26];
        calcStrFreq(s2Freq, 0, s1.length()-1, s2);
        if(checkIfEqFreq(s1Freq, s2Freq)) return true;

        for(int i = s1.length();i<s2.length();i++)
        {
            s2Freq[s2.charAt(i-s1.length())-'a']--;
            s2Freq[s2.charAt(i)-'a']++;
            if(checkIfEqFreq(s1Freq, s2Freq)) return true;
        }

        return false;        
    }

    private void calcStrFreq(int[] sFreq,  int left , int right , String s)
    {
        for(int i =left; i<=right;i++)
            sFreq[s.charAt(i)-'a']++;
    }

    private boolean checkIfEqFreq(int[] s1Freq,  int[] s2Freq)
    {
        for(int i=0;i<26;i++)
        {
            if(s1Freq[i]!=s2Freq[i]) return false;
        }
        return true;
    }
}
