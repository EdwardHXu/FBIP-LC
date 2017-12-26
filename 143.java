/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        //FBIP
        //can considered as combination of Reverse LinkedList 1&2. implemented in 3 steps
        if (head == null || head.next == null)  return;
        //first, find the middle of the list. when fast reach end of the list, slow is at middle of the list
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //second, reverse the half list after middle, prev is always the middle, curr is always middle.next, keep reversing node
        ListNode prev = slow, curr = slow.next;
        while (curr.next != null){
            ListNode node = curr.next;
            curr.next = node.next;
            node.next = prev.next;
            prev.next = node;
        }
        //thrid, start reorder one by one like: 1->2->3->6->5->4 to 1->6->2->5->3->4
        ListNode middle = slow;
        fast = middle.next;
        slow = head;
        while (slow != middle){
            middle.next = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            slow = fast.next;
            fast = middle.next;
        }
    }
}