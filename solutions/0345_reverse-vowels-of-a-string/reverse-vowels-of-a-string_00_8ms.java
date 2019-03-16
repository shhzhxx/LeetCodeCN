class Solution {
    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();
        char[] res = s.toCharArray();
        int i = 0, j = res.length - 1;
        
        while(i < j){
            while(i <= j && !isVowel(res[i])) ++i;
            if(i >= j)
                break;
            
            while(i <= j && !isVowel(res[j])) --j;
            swap(res, i, j);
            ++i;
            --j;
        }
        
        return new String(res);
    }
    
    private void swap(char[] chs, int t1, int t2){
        char tmp = chs[t1];
        chs[t1] = chs[t2];
        chs[t2] = tmp;
    }
    
    private boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}