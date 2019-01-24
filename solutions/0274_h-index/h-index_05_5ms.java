class Solution {
    public int hIndex(int[] citations) {
        quickSort(citations, 0, citations.length - 1);
        
        if(citations.length == 0 || citations[0] < 1)
            return 0;
        for(int i = 0;i < citations.length;++i){
            if(citations[i] == i + 1)
                return i + 1;
            if(citations[i] < i + 1)
                return i;
        }
        return citations.length;
    }
    
    public void quickSort(int[] nums, int left, int right) {
        if(left >= right)
            return;

        int base = nums[left];
        int i = left, j = right;

        while (i != j) {
            while (nums[j] < base && j > i) --j;
            if (j > i)
                nums[i++] = nums[j];

            while (nums[i] > base && i < j) ++i;
            if (i < j)
                nums[j--] = nums[i];
        }

        nums[i] = base;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }
}