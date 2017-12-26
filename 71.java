class Solution {
    public String simplifyPath(String path) {
        //FBIP 2R
        //string manipulation with Stack
        String result = "";
        Stack<String> stack = new Stack();
        //using HashSet to record symbols that can skip
        HashSet<String> set = new HashSet(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")){
            if (dir.equals("..") && !stack.isEmpty())
                stack.pop();
            else if (!set.contains(dir))
                stack.push(dir);
        }
        //notice that if using iterator to traversal stack will get reversed answer with pop()!
        while (!stack.isEmpty())
            result = "/" + stack.pop() + result;
        return result.isEmpty() ? "/" : result;
    }
}