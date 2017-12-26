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
    public List<String> binaryTreePaths(TreeNode root) {
        //FBIP 2R
        List<String> result = new ArrayList();
        if (root != null)
            dfs(root, result, "");
        return result;
    }
    private void dfs(TreeNode node, List<String> result, String path){
        if (node.left == null && node.right == null)    result.add(path + node.val);
        if (node.left != null)  dfs(node.left, result, path + node.val + "->");
        if (node.right != null) dfs(node.right, result, path + node.val + "->");
    }
}