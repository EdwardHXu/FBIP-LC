class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //FBIP 2R
        //classic backtracking problem
        //for this kind of problem(nums contains duplicates and result must not contain duplicate) have to sort and check i & i-1
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length == 0)   return result;
        Arrays.sort(nums);
        backtracking(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }
    private void backtracking(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums, int index){
        result.add(new ArrayList(temp));
        for (int i = index; i < nums.length; i++){
            if (i > index && nums[i] == nums[i - 1])    continue;
            temp.add(nums[i]);
            backtracking(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}