class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
    
//     // 动态规划
//     private Map<Integer, Boolean> record;

//     public boolean canWinNim(int n) {
//         record = new HashMap<>();
//         return canWinNimCore(n);
//     }

//     private boolean canWinNimCore(int n){
//         if(record.containsKey(n))
//             return record.get(n);
//         if(n <= 3){
//             record.put(n ,true);
//             return true;
//         }

//         for(int i = 1;i <= 3;++i){
//             // 如果对方输了，我就赢了
//             if(!canWinNim(n - i)){
//                 record.put(n, true);
//                 return true;
//             }
//         }

//         record.put(n, false);
//         return false;
//     }
}