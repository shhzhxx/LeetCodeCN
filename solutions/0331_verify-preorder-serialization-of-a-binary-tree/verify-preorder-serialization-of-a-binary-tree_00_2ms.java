class Solution {
    public boolean isValidSerialization(String preorder) {
        // æ çåºåº¦åå¥åº¦ç¸ç­
        if(preorder.charAt(0) == '#')
            return preorder.length() == 1;
        int degree = 1;

        for(int i = 0;i < preorder.length();i = i + 2){
            // åå»å¥åº¦
            --degree;
            if(degree < 0)
                return false;
            if(preorder.charAt(i) != '#'){
                // æ¯æ°å­æå ä¸ä¸¤ç¹åºåº¦
                while(i + 1 < preorder.length() && preorder.charAt(i + 1) != ',') ++i;
                degree += 2;
            }
        }

        return degree == 0;
    }
}