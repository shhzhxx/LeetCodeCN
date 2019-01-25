class Solution {
    public boolean makesquare(int[] nums) {
        // éåçkååçç¹æ®æåµï¼k = 4
        // éå½å¯»æ¾æ­£ç¡®çååï¼æ¾å°åæ¬¡å³è¿åtrue
        // ä¸ºäºåå°åæº¯æ¬¡æ°ï¼å¯ä»¥åå¯¹æ°ç»æåºï¼å¯»æ¾æ¶ä»é«å¼åºå
        if (nums.length < 4) return false;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 4 != 0) return false;
        Arrays.sort(nums);

        for (int i = 0; i < 4; ++i)
            if (!find(nums.length - 1, sum / 4, 0, nums))
                return false;
            
        return true;
    }

    private boolean find(int num_id, int target, int curSum, int[] nums) {
        if (num_id < 0 || curSum > target) return false;

        for (int i = num_id; i >= 0; --i) {
            // å¼ä¸ºé¶è¡¨ç¤ºå·²è¢«ä½¿ç¨
            if (nums[i] == 0) continue;
            // æå­ï¼ä¸ç¬¦åè¦æ±æ¶åæ¢å¤
            int tmp = nums[i];
            nums[i] = 0;
            if (curSum + tmp == target || find(i - 1, target, curSum + tmp, nums)) return true;
            nums[i] = tmp;
        }

        return false;
    }
}