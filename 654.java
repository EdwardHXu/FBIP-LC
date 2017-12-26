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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        //FBIP
        //recrusive with TC O(n^2) and SC O(n)
    //     return buildTree(nums, 0, nums.length - 1);
    // }
    // private TreeNode buildTree(int[] nums, int l, int r){
    //     if (l > r) return null;
    //     int maxIndex = findMax(nums, l, r);
    //     TreeNode node = new TreeNode(nums[maxIndex]);
    //     node.left = buildTree(nums, l, maxIndex - 1);
    //     node.right = buildTree(nums, maxIndex + 1, r);
    //     return node;
    // }
    // private int findMax(int[] nums, int l, int r){
    //     int maxIndex = l;
    //     for (int i = l; i <= r; i++)
    //         if (nums[i] > nums[maxIndex])
    //             maxIndex = i;
    //     return maxIndex;
        
        //iterative with TC O(n) and SC O(n)
        Deque<TreeNode> stack = new LinkedList();
        for (int i = 0; i < nums.length; i++){
            TreeNode node = new TreeNode(nums[i]);
            while (!stack.isEmpty() && stack.peek().val < nums[i])
                node.left = stack.pop();
            if (!stack.isEmpty())
                stack.peek().right = node;
            stack.push(node);
        }
        return stack.isEmpty() ? null : stack.removeLast();
    }
}

