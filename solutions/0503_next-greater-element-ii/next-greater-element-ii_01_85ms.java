class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> inc = new Stack<>();
        int doubleLen = nums.length * 2;
        int[] doubleNums = new int[doubleLen];
        int[] doubleRes = new int[doubleLen];
        
        for(int i = 0;i < doubleLen;++i){
            doubleNums[i] = nums[i % nums.length];
        }

        for (int i = 0; i < doubleLen; ++i) {
            doubleRes[i] = -1;
            while (!inc.empty() && doubleNums[inc.peek()] < doubleNums[i]) {
                doubleRes[inc.pop()] = doubleNums[i];
            }
            inc.push(i);
        }

        return Arrays.copyOf(doubleRes, nums.length);
    }
}