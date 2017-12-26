class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        //FBIP 2R similar
        //DP problem, use two dp array dp[] and dp2[], which means two most recent moves, dp2 = f[][][steps], dp = f[][][steps-1]
        //the transation equation is for each direction: dp2[cr][cc] += dp[r][c] / 8.0;
        int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};           //all possible move direction
        double result = 0.0;
        double[][] prev = new double[N][N];                         //dp named as prev
        prev[r][c] = 1;
        for (; K > 0; K--){
            double[][] curr = new double[N][N];                     //dp2 named as curr
            for (int row = 0; row < N; row++){          
                for (int col = 0; col < N; col++){          
                    for (int i = 0; i < 8; i++){                    //for prev trversal all grids and for curr traversal all dirs
                        int x = row + dr[i];
                        int y = col + dc[i];
                        if (x >= 0 && x < N && y >= 0 && y < N)
                            curr[x][y] += prev[row][col] / 8.0;     //step forward transaction equation
                    }
                }
            }
            prev = curr;
        }
        for (double[] row : prev)
            for (double i : row)
                result += i;
        return result;
    }
}