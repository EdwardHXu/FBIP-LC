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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //FBIP 2R
        //preorder[0] is the root and find it in inorder[] so that we can determine leftSub and rightSub. recrusively build this
        return helper(0, preorder, 0, inorder.length - 1, inorder);
    }
    private TreeNode helper(int preStart, int[] preorder, int inStart, int inEnd, int[] inorder){
        if (preStart >= preorder.length || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++)
            if (inorder[i] == root.val)
                rootIndex = i;
        root.left = helper(preStart + 1, preorder, inStart, rootIndex - 1, inorder);
        root.right = helper(preStart + 1 + rootIndex - inStart, preorder, rootIndex + 1, inEnd, inorder);
        return root;
    }
}