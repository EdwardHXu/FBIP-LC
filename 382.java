/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //FBIP 2R
    //typical Reservior Sampling problem: if we are dealing with nth data, we leave it with possibility 1/n, or replace it with
    //the previous n-1 data. This famous algorithm will lead to 1/n equal possibility distribution
    ListNode node;
    Random rand;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        node = head;
        rand = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode curr = node;
        int result = node.val;
        for (int i = 1; curr.next != null; i++){
            curr = curr.next;
            if (rand.nextInt(i + 1) == i)   //the possiblity to pick i-th element is 1/i since rand.nextInt(i+1) == num in [1,i]
                result = curr.val;          //will get num in [1,i] with same possibility of 1/i, when it equals to i, pick it
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */