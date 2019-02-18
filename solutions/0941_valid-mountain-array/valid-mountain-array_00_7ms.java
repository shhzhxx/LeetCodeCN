class Solution {
    public boolean validMountainArray(int[] A) {
        if(A.length < 3)
            return false;
        int i = 0, j = A.length - 1;
        while (i < A.length - 1 && A[i] < A[i + 1]) ++i;
        while (j > 0 && A[j] < A[j - 1]) --j;
        return i == j && i != 0 && j != A.length - 1;
    }
}