class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char minLetter = 'z';
        char biggerLetter = 'z' + 1;
        
        for(char ch: letters){
            minLetter = minLetter < ch ? minLetter : ch;
            if(ch > target)
                biggerLetter = biggerLetter < ch ? biggerLetter : ch;
        }
        
        if(biggerLetter > target && biggerLetter <= 'z')
            return biggerLetter;
        else 
            return minLetter;
    }
}