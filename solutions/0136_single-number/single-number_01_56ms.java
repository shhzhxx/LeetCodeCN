class Solution {
    public int singleNumber(int[] nums) {
        int point = 0;
        int next;
        int tmp;
        
        while(true){
            next = findMatch(nums, point + 1, nums[point]);
            if(next == -1){
                return nums[point];
            }
            tmp = nums[next];
            nums[next] = nums[point + 1];
            nums[point + 1] = tmp;
            point += 2;
        }
    }
    
    public int findMatch(int[] nums, int start, int base){
        for(;start < nums.length;++start){
            if(nums[start] == base){
                return start;
            }
        }
        return -1;
    }
}