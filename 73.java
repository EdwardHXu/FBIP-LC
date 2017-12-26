class Solution {
    public void setZeroes(int[][] matrix) {
    //a dumb approach is to turn this matrix into char and convert changed 0 to x and then convert back BUT cannot do it in place
        //using two sets to store the row and column will be converted 
    //     HashSet<Integer> row = new HashSet<>();
    //     HashSet<Integer> col = new HashSet<>();
    //     int m = matrix.length, n = matrix[0].length;
    //     for (int i = 0; i < m; i++){
    //         for (int j = 0; j < n; j++){
    //             if (matrix[i][j] == 0){
    //                 row.add(i);
    //                 col.add(j);
    //             }
    //         }
    //     }
    //     Iterator<Integer> itRow = row.iterator();
    //     while (itRow.hasNext()){
    //         int temp = itRow.next();
    //         for (int i = 0; i < n; i++)
    //             matrix[temp][i] = 0;
    //     }
    //     Iterator<Integer> itCol = col.iterator();
    //     while (itCol.hasNext()){
    //         int temp = itCol.next();
    //         for (int j = 0; j < m; j++)
    //             matrix[j][temp] = 0;
    //     }
    // }
        
        //FBIP 2R
        //implement in-place approach
        //store zero states in every first row and first column
        //and get states in top-down way and set matrix in buttom-up way
        int m = matrix.length, n = matrix[0].length;
        int col0 = 1;   //since row0 and col0 has the same cell so need a variable to store zero info for column 0
        for (int i = 0; i < m; i++){
            if (matrix[i][0] == 0)  col0 = 0;
            for (int j = 1; j < n; j++){                //skip the 0 col since that info store in col0
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--){
            for (int j = n - 1; j > 0; j--)            //skip the 0 col since that info store in col0
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0)  matrix[i][0] = 0; 
        }
    }
}