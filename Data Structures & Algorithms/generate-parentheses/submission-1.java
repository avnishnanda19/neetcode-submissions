class Solution {
    List<String> result ;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();

        getParanthesisResult(n , 0 , 0, new StringBuilder()); 

        return result;
    }

    private void getParanthesisResult(int n , int open  , int close, StringBuilder str)
    {
        if(str.length()==2*n)
        {
            result.add(str.toString());
        }
        if(open<n)
        {
            getParanthesisResult(n , open+1, close, str.append("("));
            str.deleteCharAt(str.length()-1);
        }
        if(close<open)
        {
            getParanthesisResult(n , open, close+1, str.append(")"));
            str.deleteCharAt(str.length()-1);
        }
    } 
}
