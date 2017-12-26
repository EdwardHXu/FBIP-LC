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
    private int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //FBIP 2R
        //dfs approach. In dfs function, computes maxSum with highest node and returns maxSum can be extedned from this node
        if (root == null)   return 0;
        dfs(root);
        return result;
    }
    private int dfs(TreeNode node){
        if (node == null)   return 0;
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        result = Math.max(result, node.val + left + right);         //update result as max path sum
        return node.val + Math.max(left, right);                    //return path sum that can be extended from node
    }
}