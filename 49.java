class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //FBIP 2R
        if (strs == null || strs.length == 0)   return null;
        HashMap<String, List<String>> map = new HashMap();  //key is sorted charArray as String, value is same characters list
        for (String str : strs){
            char[] words = str.toCharArray();
            Arrays.sort(words);
            String key = String.valueOf(words);             //sorted charArray as key in map
            if (!map.containsKey(key))
                map.put(key, new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());                 //return lists of map values lists
    }
}