//FBIP 2R
//implement TrieNode first. The basic idea is use charArray to store TrieNode
class TrieNode{
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;
    public TrieNode(){
        links = new TrieNode[R];
    }
    public boolean containsKey(char c){
        return links[c - 'a'] != null;
    }
    public TrieNode get(char c){
        return links[c - 'a'];
    }
    public void put(char c, TrieNode node){
        links[c - 'a'] = node;
    }
    public void setEnd(){
        isEnd = true;
    }
    public boolean isEnd(){
        return isEnd;
    }
}
public class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char curr = word.charAt(i);
            if (!node.containsKey(curr))
                node.put(curr, new TrieNode());
            node = node.get(curr);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char curr = word.charAt(i);
            if (!node.containsKey(curr))
                return null;
            else node = node.get(curr);
        }
        return node;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */