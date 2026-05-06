class MinStack {
    Deque<Integer> stack ; 
    Deque<Integer> minStack; 
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty() && minStack.isEmpty())
        {
            stack.push(val); 
            minStack.push(val);
            return; 
        }
        if(val<=minStack.peek())
        {
            minStack.push(val);
        }
        stack.push(val);   
    }
    
    public void pop() {
        int peek= stack.peek(); 
        if(minStack.peek()==peek)
        {
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
