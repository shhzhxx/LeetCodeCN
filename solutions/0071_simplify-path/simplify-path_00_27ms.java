class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, len = path.length();

        while(i < len){
            if(path.charAt(i) == '.'){
                if(i + 1 < len && path.charAt(i + 1) == '/'){
                    i = i + 2;
                    continue;
                }else if (i + 1 < len && path.charAt(i + 1) == '.' && (i + 2 < len && path.charAt(i + 2) == '/' || i + 2 == len)) {
                    if(!list.isEmpty())
                        list.removeLast();
                    i = i + 3;
                    continue;
                }else if(i + 1 == len)
                    break;;
            }

            if(path.charAt(i) != '/'){
                j = i;
                while(j < len && path.charAt(j) != '/') ++j;
                list.addLast(path.substring(i, j));
                i = j;
            }else
                ++i;
        }

        if(list.isEmpty()){
            sb.append('/');
        }else {
            for(String str: list){
                sb.append('/');
                sb.append(str);
            }
        }

        return new String(sb);
    }
}