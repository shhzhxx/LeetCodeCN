class Solution {
    public int trap(int[] height) {
        int res = 0;

        // i左边的最大值和右边的最大值
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        for(int i = 1;i < height.length;++i)
            left[i] = max(left[i - 1], height[i - 1]);

        for(int i = height.length - 2;i >= 0;--i)
            right[i] = max(right[i + 1], height[i + 1]);

        for(int i = 0;i < height.length;++i){
            res += max(0, min(left[i], right[i]) - height[i]);
        }

        return res;
    }

    private int max(int t0, int t1){
        return t0 > t1 ? t0 : t1;
    }

    private int min(int t0, int t1){
        return t0 < t1 ? t0 : t1;
    }
}