class Solution {
    public int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        int[] times = new int[1440];
        int i = 0, j = 1439;

        for (String timeStr : timePoints) {
            int index = parseTime(timeStr);
            ++times[index];
            if (times[index] > 1)
                return 0;
        }

        while (i != j) {
            while (times[i] == 0) ++i;
            while (times[j] == 0) --j;

            int mid = i + 1;
            while (times[mid] == 0) ++mid;

            int t1 = findSmallerSeg(i, j);
            min = t1 < min ? t1 : min;

            if (mid != j){
                int left = findSmallerSeg(i, mid);
                int right = findSmallerSeg(mid, j);
                int t2 = left < right ? left : right;
                min = t2 < min ? t2 : min;
            }

            i = mid;
        }
        return min < 720 ? min : 1440 - min;
    }

    public int parseTime(String timeStr) {
        return (timeStr.charAt(0) - '0') * 600 + (timeStr.charAt(1) - '0') * 60 + (timeStr.charAt(3) - '0') * 10 + (timeStr.charAt(4) - '0');
    }

    public int findSmallerSeg(int left, int right){
        int seg = right - left;
        return seg < 720 ? seg : 1440 - seg;
    }
}