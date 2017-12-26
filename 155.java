class MinStack {
    //FBIP
    //the key point is maintain min and do not push it into stack
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {       //push and pop are pair operator, if push two then pop two, also need to update min
        if (x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if (stack.pop() == min)
            min = stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */