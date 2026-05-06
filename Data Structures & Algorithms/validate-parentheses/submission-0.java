class Solution {
    public boolean isValid(String s) {
        // open bracket is closed 
        // open bracket correct close order
        // close bracket has open of same type 

        Deque<Character> stack = new ArrayDeque<>(); 

        for(char c : s.toCharArray())
        {
            if(c=='(' || c=='{' || c=='[')
            {
                stack.push(c);
            }
            else{
                if(stack.isEmpty()) return false;
                char top = stack.peek(); 
                switch(c)
                {
                    case ')':
                        if(top=='(')
                            stack.pop();
                        else return false;
                    break;
                    case '}':
                        if(top=='{')
                            stack.pop();
                        else return false;
                    break;
                    case ']':
                        if(top=='[')
                            stack.pop();
                        else return false;
                    break;
                }
            }
        }
        return stack.size()==0;
    }
}
