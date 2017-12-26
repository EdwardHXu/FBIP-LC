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
    public int longestConsecutive(TreeNode root) {
        //FBIP 2R
        //use dfs with time and space complexity both are O(n). The extra space comes from implicit stack space due to recursion
        if (root == null)   return 0;
        dfs(root, null, 0);
        return result;
    }
    private void dfs(TreeNode node, TreeNode parent, int length){
        if (node == null)   return;
        if (parent != null && node.val - parent.val == 1)
            length++;
        else 
            length = 1;
        result = Math.max(result, length);
        dfs(node.left, node, length);
        dfs(node.right, node, length);
    }
}
