class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        //FBIP 2R
        //typical divide and conquer: divide input into two part if encounter +-* and conquer them into result
        List<Integer> result = new ArrayList();
        if (input == null || input.length() == 0)   return result;
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*'){
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> part1Res = diffWaysToCompute(part1);
                List<Integer> part2Res = diffWaysToCompute(part2);
                for (int num1 : part1Res){
                    for (int num2 : part2Res){
                        int tempRes = 0;
                        if (c == '+')       tempRes = num1 + num2;
                        else if (c == '-')  tempRes = num1 - num2;
                        else if (c == '*')  tempRes = num1 * num2;
                        result.add(tempRes);
                    }
                }
            }
        }
        if (result.size() == 0) 
            result.add(Integer.valueOf(input));
        return result;
    }
}
