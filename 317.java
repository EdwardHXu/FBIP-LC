class Solution {
    public int shortestDistance(int[][] grid) {
        //FBIP 2R
        //run BFS for each building with time complexity O(n^2 * m^2)
        if (grid == null || grid.length == 0 || grid[0].length == 0)    return 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n];       //store sum of distance from '0' to all buildings
        int[][] reach = new int[m][n];          //store how many buildings can be reached from '0'
        int result = Integer.MAX_VALUE, buildCount = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    buildCount++;
                    Queue<int[]> queue = new LinkedList();
                    queue.offer(new int[]{i, j});
                    boolean[][] visited = new boolean[m][n];
                    int dis = 1;
                    while (!queue.isEmpty()){
                        int size = queue.size();
                        for (int k = 0; k < size; k++){
                            int[] curr = queue.poll();
                            for (int[] dir : dirs){
                                int x = curr[0] + dir[0];
                                int y = curr[1] + dir[1];
                                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0 && !visited[x][y]){
                                    distance[x][y] += dis;
                                    reach[x][y]++;
                                    visited[x][y] = true;
                                    queue.offer(new int[]{x, y});
                                }
                            }
                        }
                        dis++;              //every time run BFS expand distance from building bu increasing 1
                    }
                }
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0 && reach[i][j] == buildCount)
                    result = Math.min(result, distance[i][j]);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}