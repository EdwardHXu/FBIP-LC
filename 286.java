class Solution {
    public static final int gate = 0;
    public static final int wall = -1;
    public static final int INF = Integer.MAX_VALUE;
    public static final List<int[]> directions = Arrays.asList(
            new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1});
    public void wallsAndGates(int[][] rooms) {
        //FBIP 2R
        //using BFS to search from all the gate! using Queue implement BFS
        //classic BFS queue implement!
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList();      //queue stores the [row, col] info
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (rooms[i][j] == gate)
                    queue.add(new int[]{i, j});
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1];
            for (int[] dir : directions){
                int r = row + dir[0];
                int c = col + dir[1];
                if (r < 0 || r >= m || c < 0 || c >= n || rooms[r][c] != INF)
                    continue;
                rooms[r][c] = rooms[row][col] + 1;
                queue.add(new int[]{r ,c});
            }
        }
    }
}