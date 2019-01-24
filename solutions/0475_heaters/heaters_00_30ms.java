class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int minRadius = Integer.MIN_VALUE;
        int pivot = 0;
        int[] radiusArray = new int[houses.length];

        for(int i = 0;i < houses.length;++i){
            if(heaters[pivot] == houses[i]){
                radiusArray[i] = 0;
                continue;
            }
            else if(heaters[pivot] < houses[i]){
                while(heaters[pivot] < houses[i] && pivot < heaters.length - 1) ++pivot;
            }

            if(pivot == 0)
                radiusArray[i] = Math.abs(heaters[pivot] - houses[i]);
            else
                radiusArray[i] = Integer.min(Math.abs(houses[i] - heaters[pivot - 1]), Math.abs(heaters[pivot] - houses[i]));
        }

        for(int curRadius: radiusArray)
            minRadius = Integer.max(curRadius, minRadius);

        return minRadius;
    }
}