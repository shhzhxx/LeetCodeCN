class Solution {
    public boolean isHappy(int n) {
        if(n < 1)
            return false;

        Set<Integer> set = new HashSet<>();

        while(n != 1){
            if(set.contains(n))
                return false;
            else
                set.add(n);
            
            int next = 0;

            while(n != 0){
                next += square(n % 10);
                n /= 10;
            }

            n = next;
        }

        return true;
    }

    private int square(int n){
        return n * n;
    }
}