import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] path = new char[n * 2]; // 所有括号长度都是一样的 2n
        dfs(0, 0, n, path, ans); // 一开始没有填括号
        return ans;
    }

    // 目前填了 left 个左括号，right 个右括号
    private void dfs(int left, int right, int n, char[] path, List<String> ans) {
        // 终止条件
        if (right == n) { // 填完 2n 个括号
            ans.add(new String(path)); // 注意这里要 new String(path)，因为 path 在回溯的过程中会被修改
            // 而 ans 中加入的是当前满足条件的括号序列，而不是 path 本身
            // 本质上 path 相当于一个临时变量，用于存储当前的括号序列
            return;
        }
        if (left < n) { // 可以填左括号
            path[left + right] = '('; // left + right 就是已经填了多少个字符，也就是下一个空位的下标
            dfs(left + 1, right, n, path, ans);
        }
        if (right < left) { // 可以填右括号
            path[left + right] = ')'; // 直接覆盖
            dfs(left, right + 1, n, path, ans);
        }
    }
}