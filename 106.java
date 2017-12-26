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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //FBIP 2R
        //similar with Construct from preorder and inorder
        //root is the last element of postorder and do all the same with last problem
        return helper(0, postorder.length - 1, postorder, 0, inorder.length - 1, inorder);
    }
    private TreeNode helper(int postStart, int postEnd, int[] postorder, int inStart, int inEnd, int[] inorder){
        if (postStart > postEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++)
            if (inorder[i] == root.val)
                rootIndex = i;
        root.left = helper(postStart, postStart + rootIndex - inStart - 1, postorder, inStart, rootIndex - 1, inorder);
        root.right = helper(postStart + rootIndex - inStart, postEnd - 1, postorder, rootIndex + 1, inEnd, inorder);
        return root;
    }
}