class Solution {
    public int removeDuplicates(int[] nums) {
        // �ҵ��Ķ�����Ȼ�����⣬��һ���ⷨû�п��ǵ��������������
        int res = 0;

        for(int n: nums){
            if(res < 2 || n > nums[res - 2])
                nums[res++] = n;
        }

        return res;
    }
}