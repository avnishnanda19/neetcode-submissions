class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> groupMap = new HashMap<>(); 

        for(String str : strs)
        {
            String anagramStr = generateAnagramStr(str);
            groupMap.putIfAbsent(anagramStr, new ArrayList<>()); 
            groupMap.get(anagramStr).add(str);
        }

        return groupMap.values().stream().collect(Collectors.toList());
    }

    private String generateAnagramStr(String str)
    {
        int[] anagramArray = new int[26]; 
        for(char c : str.toCharArray())
        {
            anagramArray[c-'a']++; 
        }
        StringBuilder sb=new StringBuilder(); 
        for(int i=0;i<26;i++)
        {
            if(anagramArray[i]!=0)
            {
                sb.append('a'+i);
                sb.append(anagramArray[i]);
            }
        }
        return sb.toString();
    }
}
