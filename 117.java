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
        //use level-order traversal 
        if (root == null)   return;
        while (root != null){
            TreeLinkNode prev = new TreeLinkNode(0);
            TreeLinkNode curr = prev;
            while (root != null){                   //dealing with next level node.next
                if (root.left != null){
                    curr.next = root.left;          //this line record prev.next is current root.left (java variable assgin)
                    curr = curr.next;
                }
                if (root.right != null){
                    curr.next = root.right;
                    curr = curr.next;
                }
                root = root.next;
            }
            root = prev.next;                       //push root to next level 
        }
    }
}