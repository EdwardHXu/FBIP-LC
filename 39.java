class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //FBIP 2R
        List<List<Integer>> result = new ArrayList();
        if (candidates == null || candidates.length == 0)
            return result;
        backtracking(result, new ArrayList(), candidates, target, 0);
        return result;
    }
    private void backtracking(List<List<Integer>> result, ArrayList<Integer> temp, int[] candidates, int remain, int index){
        if (remain == 0){
            result.add(new ArrayList(temp));
            return;
        }
        if (remain < 0) return;
        for (int i = index; i < candidates.length; i++){
            temp.add(candidates[i]);
            backtracking(result, temp, candidates, remain - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}