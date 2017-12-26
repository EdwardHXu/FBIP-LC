class Solution {
    List<Integer> shape;
    boolean[][] visited;
    public int numDistinctIslands(int[][] grid) {
        //FBIP 2R
        //use LC200 dfs and HashSet to store path signature
        //path signature is direction: 1-left, 2-right, 3-down, 4-up
        if (grid == null || grid.length == 0 || grid[0].length == 0)    return 0;
        int m = grid.length, n = grid[0].length;
        visited = new boolean[m][n];
        Set<List<Integer>> set = new HashSet();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                shape = new ArrayList();
                dfs(grid, i, j, 0);
                if (!shape.isEmpty())
                    set.add(shape);
            }
        }
        return set.size();              //size of different shapes is the number distinct island
    }
    private void dfs(int[][] grid, int x, int y, int dir){
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] != 1)
            return;
        visited[x][y] = true;
        shape.add(dir);
        dfs(grid, x - 1, y, 1);
        dfs(grid, x + 1, y, 2);
        dfs(grid, x, y - 1, 3);
        dfs(grid, x, y + 1, 4);
        shape.add(0);                   //need a terminator to indentify similar path
    }
}