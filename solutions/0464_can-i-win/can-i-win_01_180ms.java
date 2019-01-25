class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // å¯éæ°å¤§äºç­äºéå¼ï¼å¿èµ¢
        if(maxChoosableInteger >= desiredTotal)
            return true;

        // æ»åå°äºéå¼ï¼æ²¡æèµ¢å®¶
        if((maxChoosableInteger * (1 + maxChoosableInteger) / 2 < desiredTotal))
            return false;

        // ç±äºmaxChoosableIntegerä¸ä¼å¤§äº20ï¼æä»¬å¯ä»¥ä½¿ç¨32ä½çintæ¥è®°å½åªäºæ°å­å·²ç»è¢«å ç¨
        int used = 0;
        // è®°å½å¨keyæåµä¸åææ¯å¦ä¼èµ¢ï¼keyå¼å¯¹åºused
        Map<Integer, Boolean> dpMap = new HashMap<>();
        return dpCanIWin(maxChoosableInteger, desiredTotal, used, dpMap);
    }

    public boolean dpCanIWin(int maxChoosableInteger, int desiredTotal, int used, Map<Integer, Boolean> dpMap){
        // å¤ç¨ä¹åçç»æ
        if(dpMap.containsKey(used))
            return dpMap.get(used);

        for(int i = 1;i <= maxChoosableInteger;++i){
            int cur = 1 << (i - 1);
            // å½åéæ©çæ°æ¯å¦å¯ç¨
            if((cur & used) == 0){
                // è¿ä¸ªç¶æä¸æä¸¤ç§æåµæ¯ç¨³èµ¢ç
                // 1. è¦æ±çæ»å¼å·²ä½äºå¯éæ°
                // 2. éæ©è¿ä¸ªæ°åï¼å¦ä¸ä¸ªç©å®¶éä»»ä¸ä¸ªæ°é½ä¼è¾
                if(desiredTotal <= i || !dpCanIWin(maxChoosableInteger, desiredTotal - i, cur | used, dpMap)){
                    dpMap.put(used, true);
                    return true;
                }
            }
        }

        dpMap.put(used, false);
        return false;
    }
}