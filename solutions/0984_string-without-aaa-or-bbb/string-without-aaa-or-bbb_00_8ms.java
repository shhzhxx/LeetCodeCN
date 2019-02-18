class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder res = new StringBuilder();
        int cnt_a = 0, cnt_b = 0;

        while(A != 0 || B != 0){
            if(cnt_a < 2 && (cnt_b == 2 || B == 0 || A >= B)){
                ++cnt_a;
                cnt_b = 0;
                res.append("a");
                --A;
            }else{
                ++cnt_b;
                cnt_a = 0;
                res.append("b");
                --B;
            }
        }

        return new String(res);
    }
}