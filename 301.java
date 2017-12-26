class Solution {
    public List<String> removeInvalidParentheses(String s) {
        //FBIP 2R
        //use dfs or backtracking 
        HashSet<String> result = new HashSet();
        int rmL = 0, rmR = 0;                               //record number of ( and ) need to be removed
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(')
                rmL++;
            else if (s.charAt(i) == ')'){
                if (rmL != 0)
                    rmL--;
                else 
                    rmR++;
            }
        }
        dfs(s, 0, result, new StringBuilder(), rmL, rmR, 0);
        return new ArrayList(result);
    }
    private void dfs(String s, int index, Set<String> result, StringBuilder sb, int rmL, int rmR, int open){
        if (rmL < 0 || rmR < 0 || open < 0) return;         //open means matched parentheses
        if (index == s.length()){
            if (rmL == 0 && rmR == 0 && open == 0)
                result.add(sb.toString());
            return;
        }
        int length = sb.length();
        if (s.charAt(index) == '('){
            dfs(s, index + 1, result, sb, rmL - 1, rmR, open);                      //not use (
            dfs(s, index + 1, result, sb.append('('), rmL, rmR, open + 1);          //use (
        }
        else if (s.charAt(index) == ')'){
            dfs(s, index + 1, result, sb, rmL, rmR - 1, open);                      //not use )
            dfs(s, index + 1, result, sb.append(')'), rmL, rmR, open - 1);          //use )
        }
        else 
            dfs(s, index + 1, result, sb.append(s.charAt(index)), rmL, rmR, open);
        sb.setLength(length);
    }
}