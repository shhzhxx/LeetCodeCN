class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewel = new HashSet<>();
        int cnt = 0;
        
        for(char ch: J.toCharArray())
            jewel.add(ch);
        
        for(char ch: S.toCharArray()){
            if(jewel.contains(ch))
                ++cnt;
        }
        
        return cnt;
    }
}