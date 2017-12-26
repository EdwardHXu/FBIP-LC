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
    //FBIP 2R
    //recursive
    // private int result = 0;
    // public int sumOfLeftLeaves(TreeNode root) {
    //     if (root == null)   return 0;
    //     dfs(root);
    //     return result;
    // }
    // private void dfs(TreeNode node){
    //     if (node == null)   return;
    //     if (node.left != null && node.left.left == null && node.left.right == null)
    //         result += node.left.val;
    //     dfs(node.left);
    //     dfs(node.right);
    // }
    
    //iterative
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)   return 0;
        int result = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();        //implement preorder traversal
            if (node.left != null){
                if (node.left.left == null && node.left.right == null)
                    result += node.left.val;
                else
                    stack.push(node.left);
            }
            if (node.right != null)
                if (node.right.left != null || node.right.right != null)
                    stack.push(node.right);
        }
        return result;
    }
}