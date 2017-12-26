class Solution {
    public int numIslands(char[][] grid) {
        //FBIP 3R
        //run dfs on grid and relabel element to 'x' if visited so keep travseraling only find '1' instead of 'x'
        if (grid == null || grid.length == 0 || grid[0].length == 0)    return 0;
        int m = grid.length, n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }
    private void dfs(char[][] grid, int x, int y){
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1')
            return;
        grid[x][y] = 'x';
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }
}