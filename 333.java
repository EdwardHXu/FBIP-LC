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
    private int result = 0;
    public int largestBSTSubtree(TreeNode root) {
        //FBIP 2R (similar)
        //naive approach is using dfs to check every subtree and update largestSize but TC is O(n^2)
    //     if (root == null)   return 0;
    //     if (root.left == null && root.right == null)    return 1;
    //     if (validBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
    //         return countNode(root);
    //     return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    // }
    // private boolean validBST(TreeNode node, int min, int max){
    //     if (node == null)   return true;
    //     if (node.val <= min || node.val >= max) return false;
    //     return validBST(node.left, min, node.val) && validBST(node.right, node.val, max);
    // }
    // private int countNode(TreeNode node){
    //     if (node == null)   return 0;
    //     return 1 + countNode(node.left) + countNode(node.right);
        
        //the key point in O(n) solution is to check BST valid and calculate max size of subtree at the same recursion 
        if (root == null)   return 0;
        dfs(root);
        return result;
    }
    private int[] dfs(TreeNode node){       //return value is 0: subtree BST size, 1: subtree min, 2: subtree max
        if (node == null)
            return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        if (left[0] == -1 || right[0] == -1)
            return new int[]{-1, 0, 0};     //{-1, 0, 0} this state means invalid BST
        if (node.val <= left[2] || node.val >= right[1])
            return new int[]{-1, 0, 0};
        int size = 1 + left[0] + right[0];
        result = Math.max(result, size);
        return new int[]{size, Math.min(node.val, left[1]), Math.max(node.val, right[2])};
    }
}