class Solution {
    public int rob(int[] nums) {
        // �ƺ�Ҳ��쳲��������в��
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];
        int canRobThis = nums[0], canNotRobThis = nums[1], res = 0;
        for(int i = 2;i < nums.length;++i){
            if(canRobThis + nums[i] > canNotRobThis){
                // ���͵��һ��
                res = canRobThis + nums[i];
                canRobThis = canRobThis > canNotRobThis ? canRobThis : canNotRobThis;
                canNotRobThis = res;
            }else {
                // �����͵��һ��
                res = canNotRobThis;
                canRobThis = canNotRobThis;
                canNotRobThis = 0;
            }
        }

        return res;
    }
}