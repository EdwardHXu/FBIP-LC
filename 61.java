/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //FBIP 2R
        //turn list into circle list and rotate 
        if (head == null || head.next == null || k == 0)    return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead, slow = dummyHead;
        //fast find length, slow.next find the new head index, dummyHead is prev node of head
        int length = 0;
        for (; fast.next != null; length++)
            fast = fast.next;
        for (int i = length - k % length; i > 0; i--)   //slow moves for length - length % k
            slow = slow.next;
        //start rotating LinkedList
        fast.next = dummyHead.next;     //tail.next = head  maek circle
        dummyHead.next = slow.next;     //find the new head
        slow.next = null;               //set tail.next as null
        return dummyHead.next;
    }
}