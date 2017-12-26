class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        //FBIP 2R
        //case1: s1 is "", so s2, s1+s2, s2+s1 are palindrome
        //case2: s2 is reversed string of s1, so s1+s2 and s2+s1 are palindrome
        //case3: if s1.substring(0, i) is palindrome, then if s2 is reversed string of s.substring(i+1), so s2+s1 is palindrome
        //case4: similar to case3, if s.substring(i+1) is palindrome and s2 is reversed of s1.substring(0, i), so s1+s2 blablabla
        Set<List<Integer>> result = new HashSet();          //to avoid duplicate so use HashSet first
        if(words == null || words.length < 2) return new ArrayList(result);
        Map<String, Integer> map = new HashMap();           //HashMap stores word and index
        for (int i = 0; i < words.length; i++)
            map.put(words[i], i);
        for (int i = 0; i < words.length; i++){
            for (int j = 0; j <= words[i].length(); j++){   //j <= ... is to handle empty string ""
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)){
                    String str2Rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2Rvs) && map.get(str2Rvs) != i){
                        List<Integer> list = new ArrayList();
                        list.add(map.get(str2Rvs));         //if str2 is reversed, s2 + s1 is palindrome
                        list.add(i);
                        result.add(list);
                    }
                }
                if (isPalindrome(str2)){
                    String str1Rvs = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1Rvs) && map.get(str1Rvs) != i){
                        List<Integer> list = new ArrayList();
                        list.add(i);                        //if str1 is reversed, s1 + s2 is palindrome
                        list.add(map.get(str1Rvs));
                        result.add(list);
                    }
                }
            }
        }
        return new ArrayList(result);
    }
    private boolean isPalindrome(String s){
        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - 1 -i))
                return false;
        return true;
    }
}