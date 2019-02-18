class Solution {
    public boolean makesquare(int[] nums) {
        // ���ϵ�k���ֵ����������k = 4
        // �ݹ�Ѱ����ȷ�Ļ��֣��ҵ��Ĵμ�����true
        // Ϊ�˼��ٻ��ݴ����������ȶ���������Ѱ��ʱ�Ӹ�ֵ����
        if (nums.length < 4) return false;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 4 != 0) return false;
        Arrays.sort(nums);

        for (int i = 0; i < 4; ++i)
            if (!find(nums.length - 1, sum / 4, 0, nums))
                return false;
            
        return true;
    }

    private boolean find(int num_id, int target, int curSum, int[] nums) {
        if (num_id < 0 || curSum > target) return false;

        for (int i = num_id; i >= 0; --i) {
            // ֵΪ���ʾ�ѱ�ʹ��
            if (nums[i] == 0) continue;
            // �ݴ棬������Ҫ��ʱ�ٻָ�
            int tmp = nums[i];
            nums[i] = 0;
            if (curSum + tmp == target || find(i - 1, target, curSum + tmp, nums)) return true;
            nums[i] = tmp;
        }

        return false;
    }
}