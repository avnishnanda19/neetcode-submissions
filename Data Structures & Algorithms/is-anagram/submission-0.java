class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sCharHash = new int[26]; 
        int[] tCharHash = new int[26];

        generateCharHash(s, sCharHash);
        generateCharHash(t, tCharHash); 

        for(int i=0;i<26;i++)
        {
            if(sCharHash[i]!=tCharHash[i])
            return false;
        } 
        return true;
    }

    private void generateCharHash(String s, int[] sCharHash){
        for(char  c : s.toCharArray())
        {
            sCharHash[c-'a']++;
        }
    }
}
