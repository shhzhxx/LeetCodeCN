class Solution {
    public String countAndSay(int n) {
        String str = "1";
        StringBuilder sb;

        while(--n != 0){
            sb = new StringBuilder();
            int cnt = 1;
            char lastCh = str.charAt(0);

            for(int i = 1;i < str.length();++i){
                char curCh = str.charAt(i);
                if(curCh == lastCh){
                    ++cnt;
                }else {
                    sb.append((char) ('0' + cnt));
                    sb.append(lastCh);
                    cnt = 1;
                    lastCh = curCh;
                }
            }
            sb.append((char) ('0' + cnt));
            sb.append(lastCh);

            str = new String(sb);
        }

        return str;
    }
}