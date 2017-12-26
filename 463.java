class Solution {
    public int islandPerimeter(int[][] grid) {
        //FBIP 
        //determine number of neighbors, the contribution of cell is (4 - neighbors)
        //easier approach is scanning matrxi in top-down & left-right way count all islands and count their right&down neighbors
        //the contribution to perimeter is 4*island - 2*neighbor
        if (grid == null || grid.length == 0 || grid[0].length == 0)    return 0;
        int m = grid.length, n = grid[0].length;
        int result = 0, island = 0, neighbor = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    island++;
                    if (i < m - 1 && grid[i + 1][j] == 1)   neighbor++; //count down neighbor
                    if (j < n - 1 && grid[i][j + 1] == 1)   neighbor++; //count right neighbor
                }
            }
        }
        result = 4 * island - 2 * neighbor;
        return result;
    }
}