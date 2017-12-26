public class AutocompleteSystem {
    //FBIP
    //use HashMap to store String and counts to implement trie tree node; then use PriorityQueue to get top 3 result
    class TrieNode{
        HashMap<Character, TrieNode> child;
        HashMap<String, Integer> count;
        boolean isWord;
        public TrieNode(){
            child = new HashMap();
            count = new HashMap();
            isWord = false;
        }
    }
    class Pair{             //helper class with same functionality of HashMap count, helpe to implement PQ
        String str;
        int count;
        public Pair(String str, int count){
            this.str = str;
            this.count = count;
        }
    }
    TrieNode root;
    String prefix;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for (int i = 0; i < sentences.length; i++)
            add(sentences[i], times[i]);
    }
    private void add(String s, int count){
        TrieNode node = root;
        for (char c : s.toCharArray()){
            TrieNode next = node.child.get(c);
            if (next == null){
                next = new TrieNode();
                node.child.put(c, next);
            }
            node = next;
            node.count.put(s, node.count.getOrDefault(s, 0) + count);
        }
        node.isWord = true;
    }
    
    public List<String> input(char c) {
        if (c == '#'){
            add(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }
        prefix += c;
        TrieNode node = root;
        for (char pc : prefix.toCharArray()){
            TrieNode next = node.child.get(pc);
            if (next == null)
                return new ArrayList<String>();
            node = next;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> (a.count == b.count ? a.str.compareTo(b.str) : b.count - a.count));
        for (String s : node.count.keySet())
            pq.add(new Pair(s, node.count.get(s)));
        List<String> result = new ArrayList();
        for (int i = 0; i < 3 && !pq.isEmpty(); i++)
            result.add(pq.poll().str);
        return result;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */