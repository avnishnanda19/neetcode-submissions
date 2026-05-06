class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> operandStack = new ArrayDeque<>(); 
        Set<String> operator = Set.of("+", "-", "*", "/");
        
        for(String s : tokens)
        {
            if(operator.contains(s))
            {
                int num1 = operandStack.pop();
                int num2 = operandStack.pop();
                int result=0;
                switch(s)
                {
                    case "+" :
                    result = num2 + num1; 
                    break;
                    case "-" :
                    result = num2 - num1; 
                    break;
                    case "*" :
                    result = num2 * num1; 
                    break;
                    case "/" :
                    result = num2 / num1; 
                    break;
                }
                operandStack.push(result);
            }
            else{
                int num = Integer.parseInt(s);
                operandStack.push(num);
            }
        }
        return operandStack.peek();
    }
}
