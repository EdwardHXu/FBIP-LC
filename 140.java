class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        //FBIP 2R
        //use dp similar with last problem but before that need to check s is breakable or not. (with complexity O(n^3)?)
        if (s == null || s.length() == 0)   return null;
        if (!isBreakable(s, wordDict))  return new ArrayList();
        List<String>[] dp = new ArrayList[s.length() + 1];
        List<String> init = new ArrayList();
        Set<String> set = new HashSet(wordDict);
        init.add("");
        dp[0] = init;
        for (int i = 1; i <= s.length(); i++){
            List<String> list = new ArrayList();
            for (int j = 0; j < i; j++){
                if (dp[j].size() > 0 && set.contains(s.substring(j, i)))
                    for (String str : dp[j])
                        list.add(str + (str.equals("") ? "" : " ") + s.substring(j, i));
            }
            dp[i] = list;
        }
        return dp[s.length()];
    }
    private boolean isBreakable(String s, List<String> wordDict){
        Set<String> set = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j < i; j++){
                if (dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
        
        //alternative approach is using DFS with HashMap to prune duplicated branches
    //     Set<String> set = new HashSet(wordDict);
    //     return dfs(s, set, new HashMap<String, List<String>>());
    // }
    // private List<String> dfs(String s, Set<String> set, HashMap<String, List<String>> map){
    //     List<String> result = new ArrayList();
    //     if (s.length() == 0){
    //         result.add("");
    //         return result;
    //     }
    //     if (map.containsKey(s)) return map.get(s);
    //     for (String word : set){
    //         if (s.startsWith(word)){
    //             List<String> sublist = dfs(s.substring(word.length()), set, map);
    //             for (String sub : sublist)
    //                 result.add(word + (sub.equals("") ? "" : " ") + sub);
    //         }
    //     }
    //     map.put(s, result);
    //     return result;
    }
}

