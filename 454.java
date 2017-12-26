class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //FBIP 2R
        //brute force complexity O(n^4). use HashMap record A+B sum and check C+D sum with time and space complexity O(n^2)
        int result = 0, n = A.length;
        HashMap<Integer, Integer> map = new HashMap();          //record sum of A+B as key and value as occurence 
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);     //if sum appear more than once, record it 
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int sum = -(C[i] + D[j]);                       //if A+B = -(C+D) then A+B+C+D is zero
                result += map.getOrDefault(sum, 0);
            }
        }
        return result;
    }
}