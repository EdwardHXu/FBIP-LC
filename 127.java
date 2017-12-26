class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //FBIP 2R
        //use BFS find the shortest path. consider only one character different words as neighbours in graph
        //start from begin and start from end: two-end BFS can speed up searching process
        if (!wordList.contains(endWord))    return 0;
        Set<String> wordSet = new HashSet(wordList);            //convert list into set to remove used element after
        Set<String> beginSet = new HashSet();
        Set<String> endSet = new HashSet();
        Set<String> visited = new HashSet();
        int result = 1, n = beginWord.length();
        beginSet.add(beginWord);
        endSet.add(endWord);                                    //two-end BFS use two sets
        while (!beginSet.isEmpty() && !endSet.isEmpty()){
            if (beginSet.size() > endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;                                  //swap beginSet and endSet can significantly speed up
            }
            Set<String> currSet = new HashSet();
            for (String word : beginSet){
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++){
                    for(char c = 'a'; c <= 'z'; c++){           //for every word try every possible permutation to get to target 
                        char prev = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        if (endSet.contains(target))
                            return result + 1;
                        if (!visited.contains(target) && wordSet.contains(target)){
                            currSet.add(target);
                            visited.add(target);    
                            wordSet.remove(target); //have to remove used word or will lead to TLE since word never used twice
                        }
                        chs[i] = prev;
                    }
                }
            }
            beginSet = currSet;
            result++;
        }
        return 0;
    }
}
