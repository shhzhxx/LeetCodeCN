class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.size() == 0 || s.length() == 0)
            return false;
        
        int len = s.length();
        boolean[] reminder = new boolean[len + 1];
        reminder[0] = true;
        
        for(int i = 1;i <= len;++i)
            for(int j = 0;j < i;++j)
                if(reminder[j] && wordDict.contains(s.substring(j, i))){
                    reminder[i] = true;
                    break;
                }
        
        return reminder[len];
    }
}