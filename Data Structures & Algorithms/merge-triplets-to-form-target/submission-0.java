class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean t1=false, t2=false ,t3=false;

        for(int[] triplet  : triplets)
        {
            if(triplet[0]>target[0] || triplet[1]>target[1] || triplet[2]>target[2])
            continue;

            if(triplet[0]==target[0]) t1=true;
            if(triplet[1]==target[1]) t2=true;
            if(triplet[2]==target[2]) t3=true;
        }
        return t1 && t2 && t3;
    }
}
