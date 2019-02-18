class Solution {
    public String validIPAddress(String IP) {
        if(IP.contains(".")){
            if(validIPv4(IP))
                return "IPv4";
        }else if(IP.contains(":")) {
            if (validIPv6(IP))
                return "IPv6";
        }

        return "Neither";
    }

    public boolean validIPv4(String IP){
        int tmp = -1;
        int dotCnt = 0;
        boolean lastSymbol = true;
        boolean firstWithZero = false;

        for(char ch: IP.toCharArray()){
            if('/' < ch && ch < ':'){
                if(firstWithZero)
                    return false;

                if(tmp == -1){
                    tmp = ch - '0';
                    if(ch == '0')
                        firstWithZero = true;
                }
                else
                    tmp = tmp * 10 + (ch - '0');

                if(tmp > 255)
                    return false;
                lastSymbol = false;
            }else if(ch == '.'){
                tmp = -1;
                if(lastSymbol)
                    return false;
                if(++dotCnt > 3)
                    return false;

                lastSymbol = true;
                firstWithZero = false;
            }else {
                return false;
            }
        }

        return dotCnt == 3 && tmp != -1;
    }

    public boolean validIPv6(String IP){
        StringBuilder sb = new StringBuilder();
        int colonCnt = 0;
        boolean lastSymbol = true;

        for(char ch: IP.toCharArray()){
            if('/' < ch && ch < ':' || '@' < ch && ch < 'G' || '`' < ch && ch < 'g'){

                lastSymbol = false;
                sb.append(ch);
                if(sb.length() > 4)
                    return false;
            }else if(ch == ':'){
                sb.delete(0, sb.length());

                if(lastSymbol)
                    return false;
                if(++colonCnt > 7)
                    return false;

                lastSymbol = true;
            }else {
                return false;
            }
        }

        return colonCnt == 7;
    }
}