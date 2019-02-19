class Solution {
    public int jump(int[] nums) {
        // ̰�ģ��������÷�Χ�����ĳ���
        int len = nums.length;
        
        if(len < 2)
            return 0;
        
        // curI����ǰλ�ã�cnt����Ծ������max����Զλ�ã�nextI���´�λ��
        int curI = 0, cnt = 1, max = 0, nextI = 0;
        
        while(curI + nums[curI] < len - 1){
            for(int i = curI + 1;i <= curI + nums[curI];++i){
                int tmp = nums[i] + i;
                if(tmp >= max){
                    max = tmp;
                    nextI = i;
                }
            }
            ++cnt;
            curI = nextI;
        }
        
        return cnt;
    }
}