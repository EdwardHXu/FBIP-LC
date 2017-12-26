/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        //FBIP 
        //the naive approach is to use HashMap storing current and its copied node with TC ans SC O(n)
        //the optimized solution is to associate original node and its copy in a single LinkedList with TC O(n) and SC O(1)
        RandomListNode curr = head, next;
        while (curr != null){   //First round: make copy of each node, and link them together side-by-side in a single list
            next = curr.next;
            RandomListNode copy = new RandomListNode(curr.label);
            curr.next = copy;
            copy.next = next;
            curr = next;
        }
        curr = head;
        while (curr != null){   //Second round: assign random pointers for the copy nodes
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        curr = head;
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode copy, copyCurr = dummyHead;
        while (curr != null){   //Third round: restore the original list, and extract the copy list
            next = curr.next.next;
            copy = curr.next;
            copyCurr.next = copy;
            copyCurr = copy;
            curr.next = next;
            curr = next;
        }
        return dummyHead.next;
        
        //naive approach with HashMap discussed above 
        // if (head == null)   return null;
        // Map<RandomListNode, RandomListNode> map = new HashMap();
        // RandomListNode node = head;
        // while (node != null){   //loop1 copy all nodes
        //     map.put(node, new RandomListNode(node.label));
        //     node = node.next;
        // }
        // node = head;
        // while (node != null){   //loop2 assign next and random pointer
        //     map.get(node).next = map.get(node.next);
        //     map.get(node).random = map.get(node.random);
        //     node = node.next;
        // }
        // return map.get(head);
    }
}