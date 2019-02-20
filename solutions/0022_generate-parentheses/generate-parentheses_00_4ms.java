class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        core(res, 0, sb, n);
        
        return res;
    }
    
    // restLeft表示栈中剩余未匹配的右括号的数量, n表示剩余未被加入过栈的左括号的数量
    private void core(List<String> res, int restLeft, StringBuilder sb, int n){
        if(n == 0 && restLeft == 0){
            res.add(new String(sb));
            return;
        }
        
        if(n == 0){
            sb.append(')');
            core(res, restLeft - 1, sb, n);
            sb.setLength(sb.length() - 1);
        }else{
            sb.append('(');
            core(res, restLeft + 1, sb, n - 1);
            sb.setLength(sb.length() - 1);
            if(restLeft > 0){
                sb.append(')');
                core(res, restLeft - 1, sb, n);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}