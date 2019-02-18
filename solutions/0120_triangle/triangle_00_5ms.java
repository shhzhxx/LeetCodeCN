class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;

        int[] tmp = new int[triangle.size()], res = new int[triangle.size()];
        res[0] = triangle.get(0).get(0);
        int minTotal = Integer.MAX_VALUE;

        for (int i = 1; i < triangle.size(); ++i) {
            tmp[0] = res[0] + triangle.get(i).get(0);
            tmp[i]=res[i-1]+triangle.get(i).get(i);
            for (int j = 1; j < i; ++j)
                tmp[j] = triangle.get(i).get(j) + (res[j] < res[j - 1] ? res[j] : res[j - 1]);
            res = Arrays.copyOf(tmp, res.length);
        }

        for (int total : res)
            minTotal = minTotal < total ? minTotal : total;

        return minTotal;
    }
}