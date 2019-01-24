class Solution {
    public int compress(char[] chars) {
        char tmp = chars[0];
        int count = 1;    // å½åå­ç¬¦æ°é
        int anchor = -1;   // æ¯æ¬¡åå¥çéç¹
        if(chars.length == 1){
            anchor = 0;
        }else{
            for(int i = 1;i < chars.length;i++){
                if(tmp == chars[i]){
                    ++count;
                    if(anchor != -1){
                        chars[anchor+1] = tmp;
                    }
                }else{
                    chars[++anchor] = tmp;
                    if(count != 1){
                        String cnt = String.valueOf(count);
                        for(int j = 0;j < cnt.length();j++){
                            chars[++anchor] = cnt.charAt(j);
                        }
                        count = 1;
                    }
                    tmp = chars[i];
                }
            }
            chars[++anchor] = tmp;
            if(count != 1){
                String cnt = String.valueOf(count);
                for(int j = 0;j < cnt.length();j++){
                    chars[++anchor] = cnt.charAt(j);
                }
            }
        }
        return ++anchor;
    }
}