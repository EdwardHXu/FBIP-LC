class Solution {
    public boolean isValid(String s) {
        //FBIP 2R
        //typical stack problem: when c is ([{ just push opposite c and check pop
        if (s == null || s.length() == 0)   return true;
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()){
            if (c == '(')   stack.push(')');
            else if (c == '[')   stack.push(']');
            else if (c == '{')   stack.push('}');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }
}

