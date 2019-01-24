class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        quickSort(houses, 0, houses.length - 1);
        quickSort(heaters, 0, heaters.length - 1);
        int minRadius = Integer.MIN_VALUE;
        int pivot = 0;
        int[] radiusArray = new int[houses.length];

        for(int i = 0;i < houses.length;++i){
            if(heaters[pivot] == houses[i]){
                radiusArray[i] = 0;
                continue;
            }
            else if(heaters[pivot] < houses[i]){
                while(heaters[pivot] < houses[i] && pivot < heaters.length - 1) ++pivot;
            }

            if(pivot == 0)
                radiusArray[i] = Math.abs(heaters[pivot] - houses[i]);
            else
                radiusArray[i] = Integer.min(Math.abs(houses[i] - heaters[pivot - 1]), Math.abs(heaters[pivot] - houses[i]));
        }

        for(int curRadius: radiusArray)
            minRadius = Integer.max(curRadius, minRadius);

        return minRadius;
    }
    
    public void quickSort(int[] nums, int left, int right) {
        if(left >= right)
            return;

        int base = nums[left];
        int i = left, j = right;

        while (i != j) {
            while (nums[j] > base && j > i) --j;
            if (j > i)
                nums[i++] = nums[j];

            while (nums[i] < base && i < j) ++i;
            if (i < j)
                nums[j--] = nums[i];
        }

        nums[i] = base;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }
}