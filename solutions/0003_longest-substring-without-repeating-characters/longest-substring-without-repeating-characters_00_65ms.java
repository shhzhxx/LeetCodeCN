class Solution {
    public int lengthOfLongestSubstring(String s) {
        // �տ�ʼ���Ҳ�ǻ������ڷ�������û�뵽Ҫ��HashSet�ӿ��ٶȣ���Ȼ��һЩ���õ����ݽṹ���ǲ�̫��Ϥ
        if (s.length() < 1)
            return 0;
        else if (s.length() == 1)
            return 1;

        Set<Character> window = new HashSet<>();
        int i = 0, j = 0, maxLen = 0, curLen = 0;

        while (j < s.length()) {
            if (!window.contains(s.charAt(j))) {
                window.add(s.charAt(j));
                ++j;
                ++curLen;
                maxLen = maxLen > curLen ? maxLen : curLen;
            } else {
                while (window.contains(s.charAt(j))) {
                    window.remove(s.charAt(i));
                    ++i;
                    --curLen;
                }
            }
        }

        return maxLen;
    }
}