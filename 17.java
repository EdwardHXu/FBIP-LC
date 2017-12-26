class Solution {
    private static final String[] words = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        //FBIP 2R
        //typical backtracking
        List<String> result = new ArrayList();
        if (digits == null || digits.length() == 0)   return result;
        backtracking(result, "", digits, 0);
        return result;
    }
    private void backtracking(List<String> result, String temp, String digits, int index){
        if (index == digits.length()){
            result.add(temp);
            return;
        }   
        String letters = words[digits.charAt(index) - '0'];         //find the letters in keyboard arrcoding to digit given
        for (int i = 0; i < letters.length(); i++)
            backtracking(result, temp + letters.charAt(i), digits, index + 1);
    }
}