class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //FBIP 3R
        //backtracking approach solving this problem with boolean[] used array to avoid duplicate
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length == 0)   return result;
        Arrays.sort(nums);
        backtracking(result, new ArrayList(), nums, new boolean[nums.length]);
        return result;
    }
    private void backtracking(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums, boolean[] used){
        if (temp.size() == nums.length){
            result.add(new ArrayList(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
                continue;
            temp.add(nums[i]);
            used[i] = true;
            backtracking(result, temp, nums, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}