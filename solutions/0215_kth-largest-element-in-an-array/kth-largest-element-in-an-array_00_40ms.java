class Solution {
    // å¿«æè§£è¦å
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, 0, nums.length - 1, k - 1);
    }
    
    private int partition(int[] nums, int left, int right, int targetIndex){
        int lPtr = left, rPtr = right, curNum = nums[left];
        
        while(lPtr < rPtr){
            while(lPtr < rPtr && nums[rPtr] <= curNum) --rPtr;
            if(lPtr == rPtr)
                break;
            nums[lPtr] = nums[rPtr];
            
            while(lPtr < rPtr && nums[lPtr] > curNum) ++lPtr;
            if(lPtr < rPtr)
                nums[rPtr] = nums[lPtr];
        }
        
        nums[lPtr] = curNum;
        if(lPtr == targetIndex)
            return curNum;
        else if(lPtr < targetIndex)
            return partition(nums, lPtr + 1, right, targetIndex);
        else
            return partition(nums, left, lPtr - 1, targetIndex);
    }
}