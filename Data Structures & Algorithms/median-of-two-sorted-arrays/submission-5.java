class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length, n2=nums2.length; 
        if((n1+n2)%2==0)
        {
            return (findMedian(nums1, nums2, (n1+n2)/2)+ findMedian(nums1, nums2, (n1+n2)/2-1))/2.0;
        }
        return findMedian(nums1, nums2, (n1+n2)/2);
    }

    private double findMedian(int[] nums1, int[] nums2, int index)
    {
        int left1 = 0, left2=0;
        int right1= nums1.length-1, right2 = nums2.length-1; 

        while(true)
        {
            if(left1>right1) return nums2[index-left1];
            if(left2>right2) return nums1[index-left2];

            int mid1 =left1 +(right1-left1)/2;
            int mid2 =left2 +(right2-left2)/2;

            if(mid1+mid2>=index)
            {
                if(nums1[mid1]>nums2[mid2])
                {
                    right1=mid1-1;
                }
                else right2=mid2-1;
            }
            else
            {
                if(nums1[mid1]>nums2[mid2])
                {
                    left2=mid2+1;
                }
                else left1=mid1+1;
            }
        }
    }
}
