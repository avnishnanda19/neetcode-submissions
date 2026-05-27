class KthLargest {
    PriorityQueue<Integer> heap ;
    int capacity ;
    public KthLargest(int k, int[] nums) {
        this.heap= new PriorityQueue<>(); 
        this.capacity = k;
        for(int i : nums)
        {
            heap.offer(i); 
            if(heap.size()>k) heap.poll();
        }
    }
    
    public int add(int val) {
        heap.offer(val); 
        if(heap.size()>capacity) heap.poll();
        return heap.peek();
    }
}
