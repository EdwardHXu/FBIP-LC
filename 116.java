/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        //FBIP
        //implement in iterative approach. the basic idea is node.left.next = node.right. level order start from most left child
        if (root == null)   return;
        TreeLinkNode prev = root;
        TreeLinkNode curr = null;
        while (prev.left != null){
            curr = prev;
            while (curr != null){
                curr.left.next = curr.right;
                if (curr.next != null)  curr.right.next = curr.next.left;
                curr = curr.next;
            }
            prev = prev.left;
        }
    }
}