class MedianFinder {
    private final PriorityQueue<Integer> minQue;
    private final PriorityQueue<Integer> maxQue;
    public MedianFinder() {
        minQue =  new PriorityQueue<>();
        maxQue = new PriorityQueue<>((a,b)->Integer.compare(b,a));
    }
    
    public void addNum(int num) {
        if(minQue.isEmpty() || num<=maxQue.peek())
        {
            maxQue.offer(num);
        }
        else{
            minQue.offer(num);
        }
        if(minQue.size()>maxQue.size())
        {
            maxQue.offer(minQue.poll());
        }
        else if(maxQue.size()-minQue.size()>1){
            minQue.offer(maxQue.poll());
        }

    }
    
    public double findMedian() {
        if(maxQue.size()==minQue.size())
        {
            return (minQue.peek()+maxQue.peek())/2.0;
        }
        return maxQue.peek();
    }
}
