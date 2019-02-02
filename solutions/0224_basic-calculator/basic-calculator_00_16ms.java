class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int operand = 0;
        int operator = 1;

        if(s == null || s.length() == 0)
            return res;

        for(int i = 0;i < s.length();++i){
            char ch = s.charAt(i);
            switch(ch){
                case '+':
                    res += operand * operator;
                    operator = 1;
                    operand = 0;
                    break;
                case '-':
                    res += operand * operator;
                    operator = -1;
                    operand = 0;
                    break;
                case '(':
                    stack.push(res);
                    stack.push(operator);
                    res = 0;
                    operator = 1;
                    operand = 0;
                    break;
                case ')':
                    // resä¸ºæ¬å·åçç»æ
                    res += operand * operator;
                    operand = 0;
                    // resæå¸¦ç¬¦å·çç¬¬äºä¸ªæä½æ°
                    res = res * stack.pop();
                    // resä¸ºå¨å±res
                    res = stack.pop() + res;
                    break;
                case ' ':
                    break;
                default:
                    operand = operand * 10 + ch - '0';
            }
        }

        return res + operand * operator;
    }
}