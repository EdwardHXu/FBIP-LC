class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        //FBIP 3R
        //multiply only non-zero element as naive math approach
        // int m = A.length, n = A[0].length, p = B[0].length;
        // int[][] result = new int[m][p];
        // for (int i = 0; i < m; i++)
        //     for (int j = 0; j < n; j++)
        //         if (A[i][j] != 0)
        //             for (int k = 0; k < p; k++)
        //                 if (B[j][k] != 0)
        //                     result[i][k] += A[i][j] * B[j][k];
        // return result;
        
        //but it's not optimal, use HashMap to record matrix B non-zero row and col, which will reduce time cost skiping same i
        int m = A.length, n = A[0].length, p = B[0].length;
        int[][] result = new int[m][p];
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap();
        for (int j = 0; j < n; j++){
            map.put(j, new HashMap<Integer, Integer>());
            for (int k = 0; k < p; k++)
                if (B[j][k] != 0)
                    map.get(j).put(k, B[j][k]);         //all set for HashMap storing all B non-zero elements
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (A[i][j] != 0)                       //faster than last approach since skip duplicated i for all j and k
                    for (int k : map.get(j).keySet())
                        result[i][k] += A[i][j] * map.get(j).get(k);
        return result;
    }
}