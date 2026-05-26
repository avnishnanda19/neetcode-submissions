class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length; 
        int n2 = nums2.length;
        int n = n1+n2; 

        if(n%2==0)
        {
            return (findMedianElement(nums1, nums2, n/2)+findMedianElement(nums1, nums2, n/2-1))/2.0;
        }
        return findMedianElement(nums1, nums2, n/2);
    }

    private int findMedianElement(int[] nums1, int[] nums2 , int element)
    {
        int left1 = 0 , left2=0; 
        int right1 =nums1.length-1, right2=nums2.length-1; 

        while(true)
        {
            if(left1>right1) return nums2[element-left1];
            if(left2>right2) return nums1[element-left2];

            int mid1 =  left1 +(right1-left1)/2;
            int mid2 =  left2 +(right2-left2)/2;

            if(mid1+mid2<element)
            {
                if(nums1[mid1]<nums2[mid2])
                {
                    left1=mid1+1;
                }
                else{
                    left2=mid2+1;
                }
            }
            else{
                if(nums1[mid1]<nums2[mid2])
                {
                    right2=mid2-1;
                }
                else{
                    right1=mid1-1;
                }
            }
        }
    }
}
