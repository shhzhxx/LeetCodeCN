class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0)
            return;
        else if(m == 0)
            for(int i = 0;i < n;++i)
                nums1[i] = nums2[i];
        
        int p = m + n - 1, i = m - 1, j = n - 1;
        
        while(p >= 0){
            if(j < 0)
                break;
            else if(i < 0)
                while(p >= 0){
                    nums1[p] = nums2[j];
                    --j;
                    --p;
                }
            else if(nums1[i] > nums2[j]){
                nums1[p] = nums1[i];
                --i;
            }else{
                nums1[p] = nums2[j];
                --j;
            }
            
            --p;
        }
    }
}