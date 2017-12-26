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
    public int kthSmallest(TreeNode root, int k) {
        //FBIP 2R
        //convert BST into array by using inorder traversal and find k element in that array
        //but speace complexity is shitty
    //     List<Integer> nums = new ArrayList<>();
    //     inorder(nums, root);
    //     return nums.get(k - 1);
    // }
    // private void inorder(List<Integer> nums, TreeNode node){
    //     if (node == null)   return;
    //     inorder(nums, node.left);
    //     nums.add(node.val);
    //     inorder(nums, node.right);
        
        //optimize speace complexity
        int count = countNode(root.left);
        if (k <= count)
            return kthSmallest(root.left, k);
        else if (k > count + 1)
            return kthSmallest(root.right, k - 1 - count);
        else
            return root.val;
    }
    private int countNode(TreeNode node){
        if (node == null)   return 0;
        return 1 + countNode(node.left) + countNode(node.right);
    }
}