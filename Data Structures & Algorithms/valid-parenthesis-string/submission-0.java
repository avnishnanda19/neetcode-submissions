class Solution {
    public boolean checkValidString(String s) {
        int leftMin=0 , leftMax = 0; 
        for(char c : s.toCharArray())
        {
            switch(c)
            {
                case '(': 
                    leftMin++;
                    leftMax++;
                break;
                case ')': 
                    leftMin--;
                    leftMax--;
                break;
                case '*': 
                    leftMin--;
                    leftMax++;
                break;
            }
            if(leftMax<0) return false; 
            if(leftMin<0) leftMin=0;
        }
        return leftMin == 0;
    }
}
