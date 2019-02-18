class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0)
            return 0;
        int start, end = timeSeries[0], time = 0;
        for(int i = 0;i < timeSeries.length;++i){
            start = timeSeries[i];
            if(end > start){
                if(end - start < duration){
                    time += duration - (end - start);
                    end = start + duration;
                }
            }else{
                end = start + duration;
                time += duration;
            }
        }
        return time;
    }
}