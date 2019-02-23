class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        res[0] = -1;

        for (int right = numbers.length - 1; right > 0; --right) {
            res[1] = right + 1;
            target -= numbers[right];
            for (int left = 0; left < numbers.length; ++left) {
                if (numbers[left] == target) {
                    res[0] = left + 1;
                    break;
                } else if (numbers[left] > target)
                    break;
            }

            if (res[0] == -1)
                target += numbers[right];
            else
                break;
        }

        return res;
    }
}