class Solution {
    public boolean verifyPreorder(int[] preorder) {
        //FBIP 2R
        //similar with preorder traversal with stack: the key point is to determine left and right substree
        // int min = Integer.MIN_VALUE;
        // Stack<Integer> stack = new Stack();
        // for (int num : preorder){
        //     if (num < min)  return false;
        //     while (!stack.isEmpty() && num > stack.peek())
        //         min = stack.pop();
        //     stack.push(num);
        // }
        // return true;
        
        //another straight-forward approach is divide and conquer: keep checking every preorder in array
        if (preorder == null || preorder.length == 0)   return true;
        return checker(preorder, 0, preorder.length - 1);
    }
    private boolean checker(int[] preorder, int start, int end){
        if (start >= end)   return true;
        int rootVal = preorder[start];
        int rightSub = -1;
        for (int i = start + 1; i<= end; i++){
            if (rightSub == -1 && preorder[i] > rootVal)    rightSub = i;
            if (rightSub != -1 && preorder[i] < rootVal)    return false;
        }
        if (rightSub == -1)
            return checker(preorder, start + 1, end);
        else 
            return checker(preorder, start + 1, rightSub - 1) && checker(preorder, rightSub, end);
    }
}