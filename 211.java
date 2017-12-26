public class WordDictionary {
    //FBIP 3R
    //implement trie first
    public class TrieNode{
        public TrieNode[] links = new TrieNode[26];
        String val = "";
    }
    private TrieNode root = new TrieNode();
    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char curr = word.charAt(i);
            if (node.links[curr - 'a'] == null)
                node.links[curr - 'a'] = new TrieNode();
            node = node.links[curr - 'a'];
        }
        node.val = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(root, word, 0);
    }
    private boolean helper(TrieNode node, String word, int index){
        if (index == word.length()) return !node.val.equals("");
        if (word.charAt(index) != '.')
            return node.links[word.charAt(index) - 'a'] != null && helper(node.links[word.charAt(index) - 'a'], word, index + 1);
        else {
            for (int i = 0; i < 26; i++)
                if (node.links[i] != null)
                    if (helper(node.links[i], word, index + 1))     //recursively keep searching char after index in word
                        return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */