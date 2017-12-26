/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //FBIP 3R
        //divide and conquer
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1)  return lists[0];
        int mid = (lists.length - 1) / 2;
        ListNode list1 = mergeKLists(Arrays.copyOfRange(lists, 0, mid + 1));    //copyOfRange does not include the last index
        ListNode list2 = mergeKLists(Arrays.copyOfRange(lists, mid + 1, lists.length));
        return mergeTwoLists(list1, list2);
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
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
    }
}