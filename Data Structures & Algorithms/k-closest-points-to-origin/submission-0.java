class Solution {

    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pointQueue = new PriorityQueue<int[]>((a, b)-> Double.compare(getDistance(b), getDistance(a)));

        for(int[] point : points)
        {
            pointQueue.offer(point); 
            if(pointQueue.size()>k)
            {
                pointQueue.poll();
            }
        }
        int[][] result  = new int[pointQueue.size()][];
        int index =0;
        while(!pointQueue.isEmpty())
            result[index++] =  pointQueue.poll();
        return result;
    }

    private double getDistance(int[] input)
    {
        return Math.sqrt(input[0]*input[0]+input[1]*input[1]);
    }
}
