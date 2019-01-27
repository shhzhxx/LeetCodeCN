class Solution {
    public int minSwap(int[] A, int[] B) {
        // å¨æè§åï¼è®°å½äº¤æ¢åä¸äº¤æ¢å½ååç´ çæå°æ¬¡æ°
        // æ¯å¤çä¸ä¸ªä¸æ ï¼ä¼éå°ä¸ç§æåµï¼å¿é¡»äº¤æ¢ãå¯ä»¥äº¤æ¢åä¸å¯ä»¥äº¤æ¢ã
        int doSwap = 1, noSwap = 0;

        for (int i = 1; i < A.length; ++i) {
            if (A[i - 1] >= B[i] || B[i - 1] >= A[i]) {
                // ä¸å¯ä»¥äº¤æ¢
                ++doSwap;
            } else if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
                // å¿é¡»äº¤æ¢
                int tmp = noSwap + 1;
                noSwap = doSwap;
                doSwap = tmp;
            } else {
                // é½å¯ä»¥
                int tmp = doSwap < noSwap ? doSwap : noSwap;
                doSwap = tmp + 1;
                noSwap = tmp;
            }
        }

        return doSwap < noSwap ? doSwap : noSwap;
    }
}