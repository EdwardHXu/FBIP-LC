/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        //FBIP 3R
        //BFS
        // if (node == null)   return null;
        // UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        // map.put(clone.label, clone);
        // Queue<UndirectedGraphNode> queue = new LinkedList();
        // queue.add(node);                                        //careful here not add clone to queue, add node to queue
        // while (!queue.isEmpty()){
        //     UndirectedGraphNode curr = queue.remove();
        //     for (UndirectedGraphNode neighbor : curr.neighbors){
        //         if (!map.containsKey(neighbor.label)){
        //             map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
        //             queue.add(neighbor);
        //         }
        //         map.get(curr.label).neighbors.add(map.get(neighbor.label));
        //     }
        // }
        // return clone;
        
        //DFS
        if (node == null)   return null;
        if (map.containsKey(node.label))
            return map.get(node.label);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors)     //same careful here traversal node.neighbors instead of clone's
            clone.neighbors.add(cloneGraph(neighbor));
        return clone;
    }
}