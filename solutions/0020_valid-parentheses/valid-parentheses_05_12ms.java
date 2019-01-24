class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1)
            return false;

        Stack<Character> stack = new Stack<Character>();
        stack.push('$');
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else if (ch == ')') {
                if (stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            } else if (ch == ']') {
                if (stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            } else if (ch == '}') {
                if (stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            }else 
                return false;
        }

        return stack.peek() == '$';
    }
}