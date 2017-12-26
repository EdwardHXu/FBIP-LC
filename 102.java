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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //FBIP 2R
        //typical BFS problem implemented with queue, the corresponding level is the size of queue
        List<List<Integer>> result = new ArrayList();
        if (root == null)   return result;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            int level = queue.size();
            List<Integer> list = new ArrayList();
            for (int i = 0; i < level; i++){
                if (queue.peek().left != null)  queue.add(queue.peek().left);
                if (queue.peek().right != null) queue.add(queue.peek().right);
                list.add(queue.poll().val);
            }
            result.add(list);
        }
        return result;
        
        //DFS version with recursive
    //     List<List<Integer>> result = new ArrayList();
    //     if (root == null)   return result;
    //     dfs(result, root, 0);
    //     return result;
    // }
    // private void dfs(List<List<Integer>> result, TreeNode node, int level){
    //     if (node == null)   return;
    //     if (level >= result.size())
    //         result.add(new ArrayList());
    //     result.get(level).add(node.val);
    //     dfs(result, node.left, level + 1);
    //     dfs(result, node.right, level + 1);
    }
}
