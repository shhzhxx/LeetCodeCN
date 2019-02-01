class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int len = heights.length;
        
        // è®¡ç®ä»¥æ¯ä¸æ ¹æ±å­ä¸ºé«çæå¤§é¢ç§¯
        for(int i = 0;i < len;++i){
            int left = i;
            int right = i;
            int height = heights[i];
            int area;
            if(height == 0)
                continue;
            
            while(right + 1 < len && heights[right + 1] >= height) ++right;
            while(left - 1 >= 0 && heights[left - 1] >= height) --left;
            
            area = height * (right - left + 1);
            max = max > area ? max : area;
        }
        
        return max;
    }
}