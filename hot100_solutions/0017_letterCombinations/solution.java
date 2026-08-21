import java.util.ArrayList;
import java.util.List;

class Solution {
    private String[] letterMap = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    // private List<String> res;//可以省略回溯中的res参数  然后在主函数入口if判空后 new
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList();
        }
        char[] d = digits.toCharArray();//直接charAt其实更方便
        List<String> res = new ArrayList();
        StringBuffer sb = new StringBuffer();
        dfs(d, 0, sb, res);// 通过传递res 并且操作即可，因为它是一个引用
        return res;
    }

    public void dfs(char[] d, int begin, StringBuffer sb, List<String> res) {
        if (begin == d.length) {
            res.add(sb.toString());// 注意其他题目res如果是列表，加入的时候需要new新的列表，否则最后一定被回溯到空列表
            return;
        } // 其他题目，不用两个target和num记录目标和当前值直接传递减掉后的target即可

        // 用当前数字字符去查表，取出这个按键对应的字母串
        char t = d[begin];
        String letters = letterMap[t - '0'];

        for (int j = 0; j < letters.length(); j++) {
            //法一使用sb
            sb.append(letters.charAt(j));
            dfs(d, begin + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1); // 回溯操作，删除当前字符

            //法二 使用string+ 直接在jvm 创建新的字符串 就不用回溯
            // dfs(d, begin + 1, sb.append(letters.charAt(j)), res);//注意使用sb由于是同一个对象，必须 deletecharat 回溯操作
            // dfs(d,begin+1,new StringBuffer(sb.toString() + letters.charAt(j)),res);//这种ok，因为字符串始终是单独新得
        }
        return;
    }

}