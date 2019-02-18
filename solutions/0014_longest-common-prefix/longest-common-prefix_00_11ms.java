class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs[0].length() == 0)
            return "";
        
        StringBuilder res = new StringBuilder();
        boolean isExit = false;
        int cnt = 0;

        while(!isExit){
            char tmpCh;
            if(cnt < strs[0].length())
                tmpCh = strs[0].charAt(cnt);
            else
                break;
            for(int i = 1;i < strs.length;++i){
                if(cnt >= strs[i].length() || strs[i].charAt(cnt) != tmpCh){
                    isExit = true;
                    break;
                }
            }
            if(!isExit){
                res.append(tmpCh);
                ++cnt;
            }
        }

        return new String(res);
    }
}