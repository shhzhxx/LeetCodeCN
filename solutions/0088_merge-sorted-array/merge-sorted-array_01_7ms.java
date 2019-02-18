class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0)
            return;
        
        int i = 0, j = 0, total = m + n;
        
        while(i < total){
            if(i >= m){
                swap(nums1, i, nums2, j);
                ++j;
            }else if(nums1[i] > nums2[j]){
                swap(nums1, i, nums2, j);
                sort(nums2, j, n - 1);
            }
            ++i;
        }
    }
    
    private void sort(int[] nums, int start, int end){
        if(start == end)
            return;
        
        while(start < end && nums[start] > nums[start + 1]){
            swap(nums, start, nums, start + 1);
            ++start;
        }
    }
    
    private void swap(int[] nums1, int i, int[] nums2, int j){
        int tmp = nums1[i];
        nums1[i] = nums2[j];
        nums2[j] = tmp;
    }
}