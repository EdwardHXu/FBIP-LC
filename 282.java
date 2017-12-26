class Solution {
    public List<String> addOperators(String num, int target) {
        //FBIP 3R
        //backtrakcing with storted multiply number: mul means value to be multiplied int the next recursion
        List<String> result = new ArrayList();
        if (num == null || num.length() == 0) return result;
        backtracking(result, "", num, target, 0, 0, 0);
        return result;
    }
    private void backtracking(List<String> result, String temp, String num, int target, int index, long val, long mul){
        if (index == num.length()){
            if (val == target)
                result.add(temp);
            return;
        }
        for (int i = index; i < num.length(); i++){
            if (i != index && num.charAt(index) == '0') break;
            long curr = Long.parseLong(num.substring(index, i + 1));
            if (index == 0)
                backtracking(result, temp + curr, num, target, i + 1, curr, curr);
            else {
                backtracking(result, temp + "+" + curr, num, target, i + 1, val + curr, curr);
                backtracking(result, temp + "-" + curr, num, target, i + 1, val - curr, -curr);
                backtracking(result, temp + "*" + curr, num, target, i + 1, val - mul + curr * mul, curr * mul);
            }
        }
    }
}