/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //FBIP 3R
        //use 3 opinters(prev, curr, next) to help solve this problem
        if (head == null)   return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        for (int i = 0; i < m - 1; i++)
            prev = prev.next;
        ListNode curr = prev.next;
        ListNode next = curr.next;
        for (int i = 0; i < n - m; i++){
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = curr.next;
        }
        return dummyHead.next;
    }
}
