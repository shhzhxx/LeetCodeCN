class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int minRadius = 0;
        for(int i = 0;i < houses.length;++i){
            int tmp = Integer.MAX_VALUE;
            for(int heater: heaters)
                tmp = Integer.min(tmp, Math.abs(houses[i] - heater));
            minRadius = Integer.max(minRadius, tmp);
        }
        
        return minRadius;
    }
}