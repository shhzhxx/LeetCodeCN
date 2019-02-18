class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // ��ѡ�����ڵ�����ֵ����Ӯ
        if(maxChoosableInteger >= desiredTotal)
            return true;

        // �ܺ�С����ֵ��û��Ӯ��
        if((maxChoosableInteger * (1 + maxChoosableInteger) / 2 < desiredTotal))
            return false;

        // ����maxChoosableInteger�������20�����ǿ���ʹ��32λ��int����¼��Щ�����Ѿ���ռ��
        int used = 0;
        // ��¼��key����������Ƿ��Ӯ��keyֵ��Ӧused
        Map<Integer, Boolean> dpMap = new HashMap<>();
        return dpCanIWin(maxChoosableInteger, desiredTotal, used, dpMap);
    }

    public boolean dpCanIWin(int maxChoosableInteger, int desiredTotal, int used, Map<Integer, Boolean> dpMap){
//        // ����֮ǰ�Ľ��
//        if(dpMap.containsKey(used))
//            return dpMap.get(used);
//
//        for(int i = 1;i <= maxChoosableInteger;++i){
//            int cur = 1 << (i - 1);
//            // ��ǰѡ������Ƿ����
//            if((cur & used) == 0){
//                // ���״̬���������������Ӯ��
//                // 1. Ҫ�����ֵ�ѵ��ڿ�ѡ��
//                // 2. ѡ�����������һ�����ѡ��һ����������
//                if(desiredTotal <= i || !dpCanIWin(maxChoosableInteger, desiredTotal - i, cur | used, dpMap)){
//                    dpMap.put(used, true);
//                    return true;
//                }
//            }
//        }
//
//        dpMap.put(used, false);
//        return false;

        if (desiredTotal <= 0) {
            dpMap.put(used, false);
            return false;
        }

        if (!dpMap.containsKey(used)) {
            dpMap.put(used, false);
            int mask = 1;
            // ���ȵĴ��е�д��������һ��д����ʮ�����ң�ֻ������boolean������dp�������ﻹ����Map���԰�
            for(int i = 1; i <= maxChoosableInteger; i++){
                int future = used | mask;
                // ��������һ��������һ�����䣬����ζ���ұ�Ӯ
                if (future != used && !dpCanIWin(maxChoosableInteger, desiredTotal - i, future, dpMap)) {
                    dpMap.put(used, true);
                    break;
                }
                mask <<= 1;
            }
        }

        return dpMap.get(used);
    }
}