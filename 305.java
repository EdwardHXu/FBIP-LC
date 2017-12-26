class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        //FBIP 2R
        //if for each position simply run dfs time conplexity should be O(k*mn)
        //typical union-find problem. finding all island unions 
        //use tree named graph (implement as array) to record all unions
        List<Integer> result = new ArrayList();
        if (m == 0 || n == 0 || positions == null)   return result;
        int[] graph = new int[m * n];
        int count = 0;
        Arrays.fill(graph, -1);
        for (int[] p : positions){
            int index = p[0] * n + p[1];    //turn 2d into 1d to find index in graph
            graph[index] = index;           //assume new point is isolated island
            count++;
            for (int[] dir : dirs){
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                int pos = x * n + y;
                if (x < 0 || x >= m || y < 0 || y >= n || graph[pos] == -1)
                    continue;
                int union = find(graph, pos);   //the basic idea for all union-find problem is iteratively find root in UF array
                if (index != union){    //index suppose to be graph[index] but why not? cause index is already in other union
                    graph[index] = union;       //union these two islands
                    index = union;
                    count--;            //since index is already in the other union, two islands are connected, count--
                }
            }
            result.add(count);
        }
        return result;
    }
    private int find(int[] graph, int index){
        while (index != graph[index]){
            graph[index] = graph[graph[index]];     //path compression
            index = graph[index];
        }
        return index;
    }
}
