public class Solution {
    //FBIP 2R
    //simply run wordSearch1 for each word if exist then add to result BUT TC is unaccepeably high!
    //use backtracking and trie combined approach
    public class TrieNode{
        TrieNode[] links = new TrieNode[26];
        String val;
    }
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for (String word : words){
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++){
                if (node.links[word.charAt(i) - 'a'] == null)
                    node.links[word.charAt(i) - 'a'] = new TrieNode();
                node = node.links[word.charAt(i) - 'a'];
            }
            node.val = word;
        }
        return root;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                backtracking(result, board, root, i, j);
        return result;
    }    
    private void backtracking(List<String> result, char[][] board, TrieNode node, int x, int y){
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)    return;
        char c = board[x][y];
        if (c == '#' || node.links[c -'a'] == null) return;     //'#' means node already visited in board
        node = node.links[c - 'a'];
        if (node.val != null){
            result.add(node.val);
            node.val = null;                                    //avoid duplicate
        }
        board[x][y] = '#';
        backtracking(result, board, node, x - 1, y);
        backtracking(result, board, node, x + 1, y);
        backtracking(result, board, node, x, y - 1);
        backtracking(result, board, node, x, y + 1);
        board[x][y] = c;
    }
}