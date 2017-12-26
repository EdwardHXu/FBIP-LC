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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //FBIP 2R
        //iteratively find LCA using BST property
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = root.val > p.val ? root.left : root.right;
        return root;
    }
}