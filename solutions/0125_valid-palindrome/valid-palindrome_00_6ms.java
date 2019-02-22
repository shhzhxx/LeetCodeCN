class Solution {
    public boolean isPalindrome(String s) {
        int i =0, j = s.length() - 1;

        while(i < j){
            char left = valid(s.charAt(i));
            char right = valid(s.charAt(j));
            int tmp = i;

            while(++i <= j && left == '#')
                left = valid(s.charAt(i));
            while(--j >= tmp && right == '#')
                right = valid(s.charAt(j));

            if(left != right)
                return false;
        }

        return true;
    }

    private char valid(char ch){
        if(ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9')
            return ch;

        if(ch >= 'A' && ch <= 'Z')
            return (char) (ch + 32);

        return '#';
    }
}