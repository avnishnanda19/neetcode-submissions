class LRUCache {
    class Node{
        int key; 
        int val;
        Node next; 
        Node prev;
        public Node(int key, int val)
        {
            this.key=key;
            this.val=val;
            next=null; 
            prev=null; 
        }
    }
    Map<Integer, Node> cache ; 
    int cap; 
    Node head ;
    Node tail;
    public LRUCache(int capacity) {
        this.cap=capacity;
        this.cache = new HashMap<>(); 
        this.head =  new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next=tail;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
        {
            return -1;
        }
        Node n = cache.get(key); 
        remove(n);
        addToHead(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        Node n =  null;
        if(!cache.containsKey(key))
        {
            n = new Node(key, value); 
            cache.put(key, n);
        }
        else {
            n = cache.get(key); 
            n.val= value;
            remove(n);
        }
        addToHead(n);

        if(cache.size()>cap)
        {
            Node last = removeLastNode();
            cache.remove(last.key);
        }

    }

    private void addToHead(Node node){
        node.next=head.next;
        head.next.prev=node;

        head.next=node; 
        node.prev=head;
    } 
    private void remove(Node node){
        node.prev.next= node.next;
        node.next.prev= node.prev; 
    }
    private Node removeLastNode(){
        if(head.next==tail) return null;
        Node n =tail.prev;
        n.prev.next=tail;
        tail.prev=n.prev;
        return n;
    }

}
