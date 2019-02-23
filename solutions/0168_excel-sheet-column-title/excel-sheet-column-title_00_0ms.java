class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        cttCore(sb, n);
        return new String(sb);
    }

    private void cttCore(StringBuilder sb, int n) {
        if (n < 1)
            return;

        cttCore(sb, (n - 1) / 26);
        sb.append((char) ((n - 1) % 26 + 'A'));
    }
}