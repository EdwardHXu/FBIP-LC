class NumMatrix {
    //FBIP 2R
    //naive brute force leads to TLE. optimize using colSum to store sum of all previous column to reduce time cost for sumRegion
    //typical stratengy for exchange TC and SC
    int[][] matrix;
    int[][] colSum;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        this.matrix = matrix;
        int m = matrix.length, n = matrix[0].length;
        colSum = new int[m + 1][n];
        for (int i = 1; i <= m; i++)
            for (int j = 0; j < n; j++)
                colSum[i][j] = colSum[i-1][j] + matrix[i-1][j];         //initialize colSum (sum of all previous col)
    }
    
    public void update(int row, int col, int val) {                     //time complexity O(m)
        for (int i = row + 1; i < colSum.length; i++)
            colSum[i][col] = colSum[i][col] - matrix[row][col] + val;
        matrix[row][col] = val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {      //time complexity O(n)
        int result = 0;
        for (int i = col1; i <= col2; i++)
            result += colSum[row2 + 1][i] - colSum[row1][i];
        return result;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */