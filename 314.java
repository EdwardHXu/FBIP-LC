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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        //FBIP 3R
        //use BFS and two queues: tree and column, and HashMap to store col with its corresponding nodes
        List<List<Integer>> result = new ArrayList();
        if (root == null)   return result;
        Queue<TreeNode> treeq = new LinkedList();
        Queue<Integer> colq = new LinkedList();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap();
        int min = 0, max = 0;
        treeq.offer(root);
        colq.offer(0);
        while (!treeq.isEmpty()){
            TreeNode node = treeq.poll();
            int col = colq.poll();
            if (!map.containsKey(col))
                map.put(col, new ArrayList());
            map.get(col).add(node.val);
            if (node.left != null){
                treeq.offer(node.left);
                colq.offer(col - 1);
                min = Math.min(min, col - 1);
            }
            if (node.right != null){
                treeq.offer(node.right);
                colq.offer(col + 1);
                max = Math.max(max, col + 1);
            }
        }
        for (int i = min; i <= max; i++)
            result.add(map.get(i));
        return result;
    }
}