class Solution {
    public boolean canJump(int[] nums) {
        // ̰�ģ��������÷�Χ�����ĳ���
        int len = nums.length;
        // curI����ǰλ�ã�max����Զλ�ã�nextI���´�λ��
        int curI = 0, max = 0, nextI = 0;

        while(curI + nums[curI] < len - 1){
            for(int i = curI + 1;i <= curI + nums[curI];++i){
                int tmp = nums[i] + i;
                if(tmp >= max){
                    max = tmp;
                    nextI = i;
                }
            }
            if(max == curI + nums[curI])
                return false;
            else
                curI = nextI;
        }

        return true;
    }
}