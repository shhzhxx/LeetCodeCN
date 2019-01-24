class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n > (flowerbed.length + 1) / 2)
            return false;
        
        int allow = 0;
        int start = -2;
        int end = 0;
        while(end < flowerbed.length){
            while(end < flowerbed.length && flowerbed[end] == 0) ++end;
            end += end == flowerbed.length ? 1 : 0;
            allow += (end - start - 2) / 2;
            start = end++;
        }
        
        return !(allow < n);
    }
}