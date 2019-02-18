class Solution {
    public int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        
        while(left < right){
            int tmp;
            if(height[left] < height[right]){
                tmp = (right - left) * height[left];
                ++left;
            }else{
                tmp = (right - left) * height[right];
                --right;
            }
            max = max > tmp ? max : tmp;
        }
        
        return max;
    }
}