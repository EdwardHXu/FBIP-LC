class Solution {
    public int maxKilledEnemies(char[][] grid) {
        //FBIP 2R (similar)
        //use DFS for every empty cell with O(mn)
        if (grid == null || grid.length == 0 || grid[0].length == 0)    return 0;
        int m = grid.length, n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '0'){
                    int kill = count(grid, i, j);
                    result = Math.max(result, kill);
                }
            }
        }
        return result;
    }
    private int count(char[][] grid, int x, int y){
        int kill = 0;
        int left = x, right = x, down = y, up = y;
        while (left-- > 0){
            if (grid[left][y] == 'W')   break;
            if (grid[left][y] == 'E')   kill++;
        }
        while (right++ < grid.length - 1){
            if (grid[right][y] == 'W')  break;
            if (grid[right][y] == 'E')  kill++;
        }
        while (down-- > 0){
            if (grid[x][down] == 'W')   break;
            if (grid[x][down] == 'E')   kill++;
        }
        while (up++ < grid[0].length - 1){
            if (grid[x][up] == 'W')     break;
            if (grid[x][up] == 'E')     kill++;
        }
        return kill;
    }
}
