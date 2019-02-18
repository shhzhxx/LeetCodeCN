class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 可选数大于等于阈值，必赢
        if(maxChoosableInteger >= desiredTotal)
            return true;

        // 总和小于阈值，没有赢家
        if((maxChoosableInteger * (1 + maxChoosableInteger) / 2 < desiredTotal))
            return false;

        // 由于maxChoosableInteger不会大于20，我们可以使用32位的int来记录哪些数字已经被占用
        int used = 0;
        // 记录在key情况下先手是否会赢，key值对应used
        Map<Integer, Boolean> dpMap = new HashMap<>();
        return dpCanIWin(maxChoosableInteger, desiredTotal, used, dpMap);
    }

    public boolean dpCanIWin(int maxChoosableInteger, int desiredTotal, int used, Map<Integer, Boolean> dpMap){
//        // 复用之前的结果
//        if(dpMap.containsKey(used))
//            return dpMap.get(used);
//
//        for(int i = 1;i <= maxChoosableInteger;++i){
//            int cur = 1 << (i - 1);
//            // 当前选择的数是否可用
//            if((cur & used) == 0){
//                // 这个状态下有两种情况是稳赢的
//                // 1. 要求的总值已低于可选数
//                // 2. 选择这个数后，另一个玩家选任一个数都会输
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
            // 领先的大佬的写法，比上一种写法快十倍左右，只是他用boolean数组做dp，我这里还是用Map试试吧
            for(int i = 1; i <= maxChoosableInteger; i++){
                int future = used | mask;
                // 我走了这一步，而另一个必输，则意味着我必赢
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