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
    //use dfs travseral the whole tree and get the diameter from max length of left or right child + 1
    private int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)   return 0;
        dfs(root);
        return result;
    }
    private int dfs(TreeNode node){
        if (node == null)   return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        result = Math.max(result, left + right);    //update max path length
        return 1 + Math.max(left, right);           //return as one of the nodes in path
    }
}