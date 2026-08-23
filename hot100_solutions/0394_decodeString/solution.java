import java.util.LinkedList;

class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++)
                    tmp.append(res);
                res = new StringBuilder(stack_res.removeLast() + tmp); // 拼接 栈里取出的外层串 + 重复后的内层串
            } else if (c >= '0' && c <= '9')
                multi = multi * 10 + Integer.parseInt(c + ""); // .parseInt方法：将字符转换为整数
            else
                res.append(c);
        }
        return res.toString();
    }
}