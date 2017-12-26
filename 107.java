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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //FBIP 2R
        //use recursive DFS instead of queue for bottom-up way
    //     List<List<Integer>> result = new ArrayList();
    //     if (root == null)   return result;
    //     bfs(root, result, 0);
    //     return result;
    // }
    // private void dfs(TreeNode node, List<List<Integer>> result, int level){
    //     if (node == null)   return;
    //     if (level >= result.size())
    //         result.add(0, new ArrayList<Integer>());            //add at the begin index of result. move prev list back
    //     bfs(node.left, result, level + 1);
    //     bfs(node.right, result, level + 1);
    //     result.get(result.size() - level - 1).add(node.val);    //add root.val into last list in result
        
        //BFS similar with previous version
        List<List<Integer>> result = new ArrayList();
        if (root == null)   return result;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()){
            int level = queue.size();
            List<Integer> list = new ArrayList();
            for (int i = 0; i < level; i++){
                if (queue.peek().left != null)  queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                list.add(queue.poll().val);
            }
            result.add(0, list);
        }
        return result;
    }
}
