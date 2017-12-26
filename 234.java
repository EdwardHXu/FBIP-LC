/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        //FBIP 2R
        //typical fast and slow pointers problem: use fast & slow pointer and reverse the later half of list
        if (head == null)   return true;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null)   slow = slow.next;   //for odd nodes, let right half smaller to make sure check overall length/2
        slow = reverse(slow);                   
        fast = head;                            //slow now becomes reversed later half and fast becomes original first half
        while (slow != null){
            if (fast.val != slow.val)           //check content of node same or not
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    private ListNode reverse(ListNode curr){
        ListNode prev = null;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}