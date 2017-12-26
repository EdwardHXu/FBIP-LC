class Solution {
    public int maximalRectangle(char[][] matrix) {
        //FBIP 2R
        //DP solution: the basic idea is to keep updating h array to record height info for each row
        //area can get from (right - left) * height
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)  return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n], left = new int[n], right = new int[n];
        Arrays.fill(right, n);
        int result = 0;
        for (int i = 0; i < m; i++){
            int currLeft = 0, currRight = n;
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '1'){
                    height[j]++;
                    left[j] = Math.max(left[j], currLeft);
                }
                else {
                    left[j] = 0;
                    currLeft = j + 1;
                    height[j] = 0;
                }
            }
            for (int j = n - 1; j >= 0; j--){
                if (matrix[i][j] == '1')
                    right[j] = Math.min(right[j], currRight);
                else {
                    right[j] = n;
                    currRight = j;
                }
            }
            for (int j = 0; j < n; j++)
                result = Math.max(result, (right[j] - left[j]) * height[j]);
        }
        return result;
    }
}