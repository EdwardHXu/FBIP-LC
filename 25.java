/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //FBIP 2R
        //Recursively reverse LinkedList
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k){     //move to k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k){
            curr = reverseKGroup(curr, k);      //reverse list with k+1 node as head, delicated partly reverse and splice 
            // head: head-pointer to direct part
            // curr: head-pointer to reversed part
            while (count-- > 0){                //start reversing
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
            }
            head = curr;
        }
        return head;
    }
}