/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    //FBIP 2R
    //use preorder traversal to build string and build tree
    private static String spliter = " ";
    private static String terminator =  "null";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    private void buildString(TreeNode node, StringBuilder sb){
        if (node == null){
            sb.append(terminator).append(spliter);
            return;
        }
        sb.append(node.val).append(spliter);
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList();
        queue.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(queue);
    }
    private TreeNode buildTree(Queue<String> queue){
        String curr = queue.poll();
        if (curr.equals(terminator))    return null;
        TreeNode node = new TreeNode(Integer.valueOf(curr));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));