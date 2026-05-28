class LRUCache {
    class Node{
        int key; 
        int value;
        Node next;
        Node prev; 
        public Node(int key , int value)
        {
            this.key=key; 
            this.value=value;
            this.next=null; 
            this.prev=null;
        }
        public Node()
        {
            this(-1,-1);
        }

    }

    Map<Integer, Integer> cache;
    Map<Integer, Node> nodeMap;
    int capacity; 
    Node head ;
    Node tail ;
    public LRUCache(int capacity) {
        this.cache = new HashMap<>(); 
        this.nodeMap = new HashMap<>(); 
        this.capacity = capacity; 
        this.head = new Node();
        this.tail= head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        
        Node n = nodeMap.get(key);
        n.prev.next =  n.next;
        if(n.next!=null) n.next.prev =n.prev;
        if(tail==n) tail=n.prev;

        insertToHead(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        Node n = null;
        if(!cache.containsKey(key))
        {
            n = new Node(key,value);
            nodeMap.put(key, n);
        }
        else {
            n = nodeMap.get(key); 
            n.value= value;
            n.prev.next =  n.next;
            if(n.next!=null) n.next.prev =n.prev;
            if(tail==n) tail=n.prev;
        }
        insertToHead(n);
        cache.put(key,value);
        // delete LRU
        if(cache.size()>capacity)
        {
            deleteTail();
        }
    }
    private void deleteTail()
    {
        Node last = tail; 
        cache.remove(last.key);
        nodeMap.remove(last.key); 

        last.prev.next= null;
        tail=last.prev;
    }
    private void insertToHead(Node n)
    {
        n.next=head.next;
        if(head.next!=null)
        head.next.prev = n;
        head.next=  n; 
        n.prev = head;

        if(head==tail)
        {
            tail=n;
        }
    }

}
