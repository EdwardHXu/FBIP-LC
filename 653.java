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
    public boolean findTarget(TreeNode root, int k) {
        //FBIP 2R
        //can convert BST into sorted list (inorder) or HashSet (dfs) with both TC O(n) and SC O(n)
        //can also implement binary search with TC O(nlogn) and SC O(height of tree)  like two binary search for two nodes
        return dfs(root, root, k);
    }
    private boolean dfs(TreeNode node1, TreeNode node2, int k){         //fix node1 and run dfs on node2
        if (node2 == null)  return false;
        return search(node1, node2, k - node2.val) || dfs(node1, node2.left, k) || dfs(node1, node2.right, k);
    }
    private boolean search(TreeNode node1, TreeNode node2, int target){ //fix node2 and find target in node1
        if (node1 == null)  return false;
        return node1.val == target && node1 != node2
            || node1.val < target && search(node1.right, node2, target)
            || node1.val > target && search(node1.left, node2, target);
    }
        
        //HashSet version
    //     if (root == null)   return false;
    //     HashSet<Integer> set = new HashSet();
    //     return dfs(root, set, k);
    // }
    // private boolean dfs(TreeNode node, HashSet<Integer> set, int k){
    //     if (node == null)   return false;
    //     if (set.contains(k - node.val))
    //         return true;
    //     set.add(node.val);
    //     return dfs(node.left, set, k) || dfs(node.right, set, k);
    // }
}