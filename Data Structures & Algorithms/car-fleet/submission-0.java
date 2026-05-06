class Solution {
    class Node{
        int distance; 
        double time ; 

        public Node(int distance, double time)
        {
            this.distance= distance;
            this.time =  time;
        }

        public Node(){}
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length; 
        List<Node> distanceTimes  = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            int distance = target-position[i];
            double time = ((double)distance)/speed[i];

            Node  car = new Node(distance, time);
            distanceTimes.add(car);
        }

        Collections.sort(distanceTimes , (a,b)->Integer.compare(a.distance, b.distance));

        Deque<Double> fleet = new ArrayDeque<>();
        for(Node car : distanceTimes)
        {
            if(fleet.isEmpty() || car.time>fleet.peek())
                fleet.push(car.time);
        }
        return fleet.size();
    }
}
