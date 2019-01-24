class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // é¦åï¼æ©åä¸åæ°ç»ä»¥è§£å³å¾ªç¯é®é¢ï¼
        // å¶æ¬¡ï¼ä½¿ç¨åè°æ ï¼æ é¡¶å°æ åºæä»å°å°å¤§çé¡ºåºæåï¼æ¯ä¸æ¬¡æ°çæ°é½è¦åæ ï¼åæ åæç§åè°æ è§åéåºæ çç´¢å¼å¯¹åºçä¸ä¸ä¸ªæ´å¤§æ°å­å°±æ¯æ¬æ¬¡åæ çæ°ã
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