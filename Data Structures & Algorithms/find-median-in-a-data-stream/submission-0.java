class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap =  new PriorityQueue<>(); 
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num<=maxHeap.peek())
        {
            maxHeap.offer(num);
        }
        else{
            minHeap.offer(num); 
        }
        if(minHeap.size()>maxHeap.size())
        {
            maxHeap.offer(minHeap.poll());
        }
        else if(maxHeap.size()-minHeap.size()>1)
        {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size())
        {
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
        return maxHeap.peek();
    }
}
