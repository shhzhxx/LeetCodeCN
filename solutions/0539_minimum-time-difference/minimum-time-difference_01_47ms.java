class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int minSeg = Integer.MAX_VALUE;
        int[] timeStamps = new int[timePoints.size()];

        for(int i = 0;i < timeStamps.length;++i){
            timeStamps[i] = parseTime(timePoints.get(i));
        }

        for(int i = 0;i < timeStamps.length - 1;++i){
            int tmp = timeStamps[i + 1] - timeStamps[i];
            minSeg = (tmp < minSeg) ? tmp : minSeg;
        }

        int tmp = timeStamps[0] + 1440 - timeStamps[timeStamps.length - 1];
        minSeg = (tmp < minSeg) ? tmp : minSeg;
        return minSeg;
    }

    public int parseTime(String timePoint){
        int hour = Integer.parseInt(timePoint.substring(0, 2));
        int second = Integer.parseInt(timePoint.substring(3, 5));
        return hour * 60 + second;
    }
}