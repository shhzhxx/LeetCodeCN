class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();

        for(String str: tokens){
            if(!isOperator(str))
                numStack.push(Integer.valueOf(str));
            else{
                int t1 = numStack.pop();
                int t0 = numStack.pop();
                switch (str) {
                    case "*":
                        numStack.push(t0 * t1);
                        break;
                    case "/":
                        numStack.push(t0 / t1);
                        break;
                    case "+":
                        numStack.push(t0 + t1);
                        break;
                    default:
                        numStack.push(t0 - t1);
                        break;
                }
            }
        }

        return numStack.pop();
    }

    private boolean isOperator(String str){
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
}