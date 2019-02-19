class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if(digits.length() < 1)
            return res;
        
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder sb = new StringBuilder();
        lcCore(res, map, sb, 0, digits);

        return res;
    }

    private void lcCore(List<String> res, Map<Character, String> map, StringBuilder sb, int curLen, String digits) {
        if (curLen == digits.length()) {
            res.add(new String(sb));
            return;
        }

        String curStr = map.get(digits.charAt(curLen));

        for (int i = 0; i < curStr.length(); ++i) {
            sb.append(curStr.charAt(i));
            lcCore(res, map, sb, curLen + 1, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}