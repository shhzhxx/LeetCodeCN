class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length < 2)
            return false;

        int maxPositiveNum = 0;
        int minNegativeNum = 0;
        int zeroCount = 0;
        for (int t: nums){
            if(t > 0){
                if(maxPositiveNum < t)
                    maxPositiveNum = t;
                else if(maxPositiveNum == t)
                    return true;
            }else if(t < 0){
                if(minNegativeNum > t)
                    minNegativeNum = t;
                else if(minNegativeNum == t)
                    return true;
            }else {
                ++zeroCount;
                if(zeroCount == 2)
                    return true;
            }
        }

        minNegativeNum = 0 - minNegativeNum;
        int[] maxPositiveMap = new int[maxPositiveNum];
        int[] minNegativeMap = new int[minNegativeNum];
        int point;
        for (int t: nums) {
            if (t > 0) {
                point = t % maxPositiveNum;
                ++maxPositiveMap[point];
                if (maxPositiveMap[point] == 2)
                    return true;
            } else if (t < 0) {
                point = (0 - t) % minNegativeNum;
                ++minNegativeMap[point];
                if (minNegativeMap[point] == 2)
                    return true;
            }
        }
        return false;
    }
}