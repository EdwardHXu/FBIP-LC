/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        //FBIP 3R
        //first-time-implement recursive
    //     if (root == null)   return true;
    //     if (root.val > getMax(root.left) && root.val < getMin(root.right))
    //         return isValidBST(root.left) && isValidBST(root.right);
    //     else return false;
    // }
    // private long getMax(TreeNode node){
    //     if (node == null)   return Long.MIN_VALUE;
    //     long max = node.val;
    //     max = Math.max(Math.max(max, getMax(node.left)), getMax(node.right));
    //     return max;
    // }
    // private long getMin(TreeNode node){
    //     if (node == null)   return Long.MAX_VALUE;
    //     long min = node.val;
    //     min = Math.min(Math.min(min, getMin(node.left)), getMin(node.right));
    //     return min;
        
        //optimized recursive
    //     return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    // }
    // private boolean isValid(TreeNode node, long min, long max){
    //     if (node == null)   return true;
    //     if (node.val <= min || node.val >= max)
    //         return false;
    //     return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    // }
        
        //iterative with checking inorder traversal 
        if (root == null)   return true;
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;
        TreeNode prev = null;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (prev != null && prev.val >= node.val)
                return false;
            prev = node;
            node = node.right;
        }
        return true;
    }
}
