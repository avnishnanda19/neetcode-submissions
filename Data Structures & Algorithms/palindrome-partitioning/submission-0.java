class Solution {
    List<List<String>> result ;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>(); 
        Deque<String> out = new ArrayDeque<>();
        dfs(s,out,0);
        return result;
    }
    private void dfs(String s , Deque<String> out , int index)
    {
        if(index==s.length())
        {
            result.add(new ArrayList<>(out));
            return;
        }
        for(int i =index+1;i<=s.length();i++)
        {
            if(isPalindrome(s, index, i-1))
            {
                out.push(s.substring(index, i));
                dfs(s, out, i);
                out.pop();
            }
        }
    }
    private boolean isPalindrome(String s , int i, int j)
    {
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
