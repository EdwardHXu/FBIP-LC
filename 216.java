class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        //FBIP 2R (potential follow-up)
        List<List<Integer>> result = new ArrayList();
        if (k == 0) return result;
        backtracking(result, new ArrayList(), k, n, 1);
        return result;
    }
    private void backtracking(List<List<Integer>> result, ArrayList<Integer> temp, int k, int remain, int start){
        if (k == temp.size() && remain == 0){
            result.add(new ArrayList(temp));
            return;
        }
        if (remain < 0) return;
        for (int i = start; i < 10; i++){
            temp.add(i);
            backtracking(result, temp, k, remain - i, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}