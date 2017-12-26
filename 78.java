class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //FBIP 2R
        //classic backtracking problem
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length == 0)   return result;
        backtracking(result, new ArrayList(), nums, 0);
        return result;
    }
    private void backtracking(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums, int index){
        result.add(new ArrayList(temp));
        for (int i = index; i < nums.length; i++){
            temp.add(nums[i]);
            backtracking(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}