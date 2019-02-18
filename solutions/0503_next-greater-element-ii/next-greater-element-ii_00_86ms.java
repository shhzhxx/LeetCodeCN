class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // 首先，扩充一倍数组以解决循环问题；
        // 其次，使用单调栈，栈顶到栈底按从小到大的顺序排列，每一次新的数都要压栈，压栈前按照单调栈规则退出栈的索引对应的下一个更大数字就是本次压栈的数。
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