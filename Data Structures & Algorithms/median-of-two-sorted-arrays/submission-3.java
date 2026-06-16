class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length; 
        int n2 = nums2.length;

        if((n1+n2)%2==0)
        {
            return (findMedian(nums1, nums2, (n1+n2)/2)+ findMedian(nums1, nums2, (n1+n2)/2-1))/2.0 ;
        }
        return findMedian(nums1, nums2, (n1+n2)/2);
    }

    private double findMedian(int[] nums1, int[] nums2, int index)
    {
        int l1 =0, l2=0;
        int r1= nums1.length-1, r2= nums2.length-1;

        while(true)
        {
            if(l1>r1) return nums2[index-l1];
            if(l2>r2) return nums1[index-l2];

            int mid1 = l1+(r1-l1)/2, mid2 = l2+(r2-l2)/2;

            if(mid1+mid2>=index)
            {
                if(nums1[mid1]>nums2[mid2])
                {
                    r1=mid1-1;
                }
                else r2=mid2-1;

            }
            else{
                 if(nums1[mid1]>nums2[mid2])
                {
                    l2=mid2+1;
                }
                else l1=mid1+1;

            }
        }
    }
}
