class Solution {
    public boolean isValidSerialization(String preorder) {
        // 树的出度和入度相等
        if(preorder.charAt(0) == '#')
            return preorder.length() == 1;
        int degree = 1;

        for(int i = 0;i < preorder.length();i = i + 2){
            // 减去入度
            --degree;
            if(degree < 0)
                return false;
            if(preorder.charAt(i) != '#'){
                // 是数字才加上两点出度
                while(i + 1 < preorder.length() && preorder.charAt(i + 1) != ',') ++i;
                degree += 2;
            }
        }

        return degree == 0;
    }
}