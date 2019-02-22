class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, LinkedList<String>> map = new HashMap<>();
        
        for(String str: strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            
            if(!map.containsKey(key))
                map.put(key, new LinkedList<>());
            
            map.get(key).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}