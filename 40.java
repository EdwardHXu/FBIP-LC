class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //FBIP 2R
        //cause candidates may contain duplicate and solution set cannot contain duplicate, so determine not 0 is needed
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(candidates);
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
            if (i > index && candidates[i] == candidates[i-1])
                continue;
            temp.add(candidates[i]);
            backtracking(result, temp, candidates, remain - candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}