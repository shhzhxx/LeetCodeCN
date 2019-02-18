class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int curStage = 2, last_2 = cost[0], last_1 = cost[1], res = last_1;

        for(int i = 2;i < cost.length;++i){
            res = (last_2 < last_1 ? last_2 : last_1) + cost[i];
            last_2 = last_1;
            last_1 = res;
        }

        return last_2 < last_1 ? last_2 : last_1;
    }
}