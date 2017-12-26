// class LRUCache {
//     //FBIP
//     //lazy implement is to use LinkedHashMap
//     private LinkedHashMap<Integer, Integer> map;
//     private int cap;
//     public LRUCache(int capacity) {
//         cap = capacity;
//         map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){   //0.75f is the default of loadFactor which determines
//             protected boolean removeEldestEntry(Map.Entry eldest){          //when LinkedHashMap should be doubled. And true is 
//                 return size() > cap;                                        //for re-touch element when access it
//             }
//         };
//     }
    
//     public int get(int key) {
//         return map.getOrDefault(key, -1);
//     }
    
//     public void put(int key, int value) {
//         map.put(key, value);
//     }
// }
    
class Node{
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
public class LRUCache{
    //use double linked list and HashMap. constant time to add or remove from double linked list
    HashMap<Integer, Node> map;
    int count, capacity;
    Node head, tail;
    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap();
        count = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }
    private void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addToHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    public int get(int key){
        if (map.get(key) != null){
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);                        //all operation with node should update node position at double linked list
            return result;                          //which means should delete it first and add it to head
        }
        return -1;
    }
    
    public void put(int key, int value){
        if (map.get(key) != null){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }
        else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity){
                count++;
                addToHead(node);
            }
            else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */