class Solution {
    public int removeDuplicates(int[] nums) {
        // 我的阅读理解果然有问题，上一个解法没有考虑到数组是排序过的
        int res = 0;

        for(int n: nums){
            if(res < 2 || n > nums[res - 2])
                nums[res++] = n;
        }

        return res;
    }
}