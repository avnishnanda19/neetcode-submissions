class Solution {
    class Node{
        int temperature; 
        int day; 
        public Node(int temperature, int day)
        {
            this.temperature = temperature; 
            this.day  =  day;
        }
        public Node(){}
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Node> temperatureDayStack= new ArrayDeque<>();
        int[] hotTemperatureDelay = new int[n];

        for(int i=n-1; i>=0;i--)
        {
            Node currentTempNode= new Node(temperatures[i], i); 
            
            while(!temperatureDayStack.isEmpty() && 
            temperatureDayStack.peek().temperature<=temperatures[i])
            temperatureDayStack.pop();

            if(temperatureDayStack.isEmpty())
                hotTemperatureDelay[i]=0;
            else{
                hotTemperatureDelay[i]=temperatureDayStack.peek().day - i;
            }
            temperatureDayStack.push(currentTempNode);
        }
        return hotTemperatureDelay;
    }
}
