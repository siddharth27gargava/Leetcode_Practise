class LRUCache {
    
    public class Node{
        int key;
        int value;
        Node next;
        Node prev;  
    }
    
    HashMap<Integer, Node> map;
    Node head = new Node();
    Node tail = new Node();
    int capacity = 0;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        
        //double lineked list
        head.next = tail;
        tail.prev = head;
        
        this.capacity = capacity;
    }
    
    public void add(Node node){
        Node head_next = head.next;
        
        //Connect node with head_next
        node.next = head_next;
        head_next.prev = node;
        
        //Connect node with head
        head.next = node;
        node.prev = head;
    }
    
    public void remove(Node node){
        Node node_prev = node.prev;
        Node node_next = node.next;
        
        //Connect node_prev and node_next
        node_prev.next = node_next;
        node_next.prev = node_prev;
    }
    
    public int get(int key) {
        int result = -1;
        
        Node nn = map.get(key);
        
        if(nn!=null){
            remove(nn);
            result = nn.value;
            add(nn);
        }
        
        return result;
    }
    
    public void put(int key, int value) {
        Node nn = map.get(key);
        
        if(nn!=null){
            remove(nn);
            nn.value = value;
            add(nn);
        } else{
            if(map.size() >= capacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
            } 
            
            Node node = new Node();
            node.value = value;
            node.key = key;
            map.put(key,node);
            add(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */