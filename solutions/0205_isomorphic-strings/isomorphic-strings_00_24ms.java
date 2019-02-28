class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null)
            return false;

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); ++i) {
            char curS = s.charAt(i);
            char curT = t.charAt(i);
            if (map.containsKey(curS)) {
                if (map.get(curS) != t.charAt(i))
                    return false;
            } else if (set.contains(curT)) {
                return false;
            } else {
                map.put(curS, curT);
                set.add(curT);
            }
        }

        return true;
    }
}