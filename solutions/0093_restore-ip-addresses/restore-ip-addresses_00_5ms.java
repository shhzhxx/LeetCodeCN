class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        if(s.length() < 4 || s.length() > 12)
            return res;

        StringBuilder sb = new StringBuilder();
        core(res, s, sb, 0, 0);

        return res;
    }

    private void core(List<String> res, String s, StringBuilder sb, int index, int cnt){
        if(s.length() - index < 4 - cnt)
            return;

        if(cnt == 3){
            if(index >= s.length() || (s.charAt(index) == '0' && s.length() - index > 1))
                return;
            int val = Integer.valueOf(s.substring(index));
            if(val < 256){
                sb.append(val);
                res.add(new String(sb));
            }
            return;
        }

        int originalSize = sb.length();
        for(int offset = 1;offset < 4 && index + offset <= s.length() + cnt - 3;++offset){
            int val = Integer.valueOf(s.substring(index, index + offset));
            if(val < 256){
                sb.append(val);
                sb.append('.');
                core(res, s, sb, index + offset, cnt + 1);
                sb.setLength(originalSize);
            }
            if(s.charAt(index) == '0')
                break;
        }
    }
}