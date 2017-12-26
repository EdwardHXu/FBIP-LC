/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */ 
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //FBIP 2R
        //recrusive approach
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } 
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        
        //follow-up do it in iterative way          
        // if (l1 == null) return l2;
        // if (l2 == null) return l1;
        // ListNode dummyHead = new ListNode(0);
        // ListNode curr = dummyHead;
        // while (l1 != null && l2 != null){
        //     if (l1.val < l2.val){
        //         curr.next = l1;
        //         l1 = l1.next;
        //     }
        //     else {
        //         curr.next = l2;
        //         l2 = l2.next;
        //     }
        //     curr = curr.next;
        // }
        // while (l1 != null){
        //     curr.next = l1;
        //     l1 = l1.next;
        //     curr = curr.next;
        // }
        // while (l2 != null){
        //     curr.next = l2;
        //     l2 = l2.next;
        //     curr = curr.next;
        // }
        // return dummyHead.next;
    }
}