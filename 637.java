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
    public List<Double> averageOfLevels(TreeNode root) {
        //FBIP 2R
        //record level sum and num of nodes by using BFS
        List<Double> result = new ArrayList();
        if (root == null)   return result;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            double sum = 0.0;
            for (int i = 0; i < count; i++){        //for every level has n nodes where n is the size of queue
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null)  queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(sum / count);
        }
        return result;
    }
}
