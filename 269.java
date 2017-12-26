class Solution {
    public String alienOrder(String[] words) {
        //FBIP 2R
        //words order can be converted into directed graph, then we need to sort this graph for degrees, use BFS
        String result = "";
        if (words == null || words.length == 0) return result;
        Map<Character, Set<Character>> map = new HashMap();
        Map<Character, Integer> degree = new HashMap();
        for (String s : words)
            for (char c : s.toCharArray())
                degree.put(c, 0);            //initialize directed graph
        for (int i = 0; i < words.length - 1; i++){
            String curr = words[i];
            String next = words[i + 1];
            int length = Math.min(curr.length(), next.length());
            for (int j = 0; j < length; j++){
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2){
                    Set<Character> set = new HashSet();
                    if (map.containsKey(c1))
                        set = map.get(c1);
                    if (!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);     //for adjecent words update degree
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList();
        for (char c : degree.keySet())
            if (degree.get(c) == 0) queue.add(c);               //find top letter
        while (!queue.isEmpty()){
            char c = queue.poll();
            result += c;
            if (map.containsKey(c)){
                for (char c2 : map.get(c)){
                    degree.put(c2, degree.get(c2) - 1);
                    if (degree.get(c2) == 0)
                        queue.add(c2);
                }
            }
        }
        if (result.length() != degree.size())   return "";
        return result;
    }
}