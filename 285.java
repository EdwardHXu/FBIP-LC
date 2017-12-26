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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //FBIP 2R
        //since it's inorder traversal, just find the smallest one larger than given target. like binary search
        
        //iterative
        // TreeNode successor = null;
        // while (root != null){
        //     if (root.val > p.val){
        //         successor = root;
        //         root = root.left;
        //     }   
        //     else 
        //         root = root.right;
        // }
        // return successor;
        
        //recursive 
        if (root == null)   return null;
        if (root.val <= p.val)
            return inorderSuccessor(root.right, p);
        else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }
    
    //recursive find predecessor
    // if (root == null)   return null;
    // if (root.val >= p.val)
    //     return inorderPredecessor(root.left, p);
    // else{
    //     TreeNode right = inorderPredecessor(root.right, p);
    //     return right == null ? root : right;
    // }
}
