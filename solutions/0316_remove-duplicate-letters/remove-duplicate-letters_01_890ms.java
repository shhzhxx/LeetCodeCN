class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] isExist = new boolean[26];
        int[] letterCnt = new int[26];
        List<Character> watchList = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); ++i)
            ++letterCnt[s.charAt(i) - 'a'];

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            if (isExist[index])
                continue;

            if(letterCnt[index] == 1){
                watchList.add(ch);
                char min = '{';
                while(!watchList.isEmpty() && min != ch){
                    min = '{';
                    int minIndex = -1;
                    for(int j = 0;j < watchList.size();++j){
                        char curChar = watchList.get(j);
                        if(curChar < min && !isExist[curChar - 'a']){
                            min = curChar;
                            minIndex = j;
                        }
                    }

                    if(min < '{'){
                        sb.append(min);
                        isExist[min - 'a'] = true;
                        watchList = watchList.subList(minIndex + 1, watchList.size());
                    }
                }
            }else if(letterCnt[index] > 1){
                watchList.add(ch);
                --letterCnt[index];
            }
        }

        return new String(sb);
    }
}