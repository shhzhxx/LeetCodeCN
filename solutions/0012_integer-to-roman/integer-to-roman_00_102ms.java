class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        for(int i = 0;i < vals.length;++i){
            while(num >= vals[i]){
                num -= vals[i];
                sb.append(romans[i]);
            }
        }
        
        return new String(sb);
    }
}