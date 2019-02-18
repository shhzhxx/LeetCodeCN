class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() < 1)
            return 0;
        
        int[] next = getNext(needle);
        int hI = 0, nI = 0;
        int hLen = haystack.length(), nLen = needle.length();

        while(hI < hLen && nI < nLen){
            if(nI == -1 || haystack.charAt(hI) == needle.charAt(nI)){
                ++hI;
                ++nI;
            }else
                nI = next[nI];
        }

        if(nI == nLen)
            return hI - nLen;
        else
            return -1;
    }

    public int[] getNext(String pattern) {
        int cur = 0, last = -1;
        int[] next = new int[pattern.length()];
        next[0] = -1;

        while (cur < pattern.length() - 1) {
            if (last == -1 || pattern.charAt(cur) == pattern.charAt(last))
                next[++cur] = ++last;
            else
                last = next[last];
        }

        return next;
    }
}