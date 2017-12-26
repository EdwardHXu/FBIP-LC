class Solution {
    public boolean validTree(int n, int[][] edges) {
        //FBIP 2R
        //typical union-find problem: if there is a circle then graph is not a tree
        int[] graph = new int[n];
        Arrays.fill(graph, -1);
        for (int i = 0; i < edges.length; i++){
            int x = find(graph, edges[i][0]);
            int y = find(graph, edges[i][1]);
            if (x == y) return false;           //if two nodes are in the same union there is a circle
            graph[x] = y;                       //don't forget put these two connected nodes in the same union 
        }
        return edges.length == n - 1;
    }
    private int find(int[] graph, int node){
        if (graph[node] == -1)  return node;
        else return find(graph, graph[node]);
    }
}
