class Solution {
    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();
        char[] res = new char[s.length()];
        
        for(int i = 0;i < res.length;++i){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                res[i] = 'a';
                stack.push(ch);
            }else
                res[i] = ch;
        }
        
        for(int i = 0;i < res.length;++i){
            if(res[i] == 'a')
                res[i] = stack.pop();
        }
        
        return new String(res);
    }
    
    private boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}