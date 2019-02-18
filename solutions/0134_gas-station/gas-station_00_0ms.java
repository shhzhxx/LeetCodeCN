class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int minBalance = Integer.MAX_VALUE, balance = 0, start = 0;
        for(int i = 0;i < gas.length;++i){
            balance += gas[i] - cost[i];
            if(balance < minBalance){
                minBalance = balance;
                start = (i + 1) % gas.length;
            }
        }
        if(balance < 0)
            return -1;
        
        return start;
    }
}