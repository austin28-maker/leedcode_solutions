import java.util.ArrayList;
import java.util.List;

// 回溯法
// 选/不选 的思想
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, 0, s, path, ans);
        return ans;
    }

    // 现在 s 未被分割的部分为 [start, n-1]
    // 当前位于下标 i，讨论是否在 i 和 i+1 之间切一刀
    private void dfs(int i, int start, String s, List<String> path, List<List<String>> ans) {
        if (i == s.length()) { // s 分割完毕
            ans.add(new ArrayList<>(path)); // 复制 path
            return;
        }

        // 不分割
        if (i < s.length() - 1) { // i=n-1 时必须分割（这是最后一段），i<n-1 时才可以不分割
            dfs(i + 1, start, s, path, ans);
        }

        // 分割，那么得到子串 [start, i]
        if (isPalindrome(s, start, i)) { // 判断子串 [start, i] 是不是回文串
            path.add(s.substring(start, i + 1)); // .substring(start, end)，左闭右开区间，不包含end
            // 现在 s 未被分割的部分为 [i+1, n-1]
            dfs(i + 1, i + 1, s, path, ans);
            path.removeLast(); // path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}

// 枚举选哪个 的思想
// class Solution {
//     public List<List<String>> partition(String s) {
//         List<List<String>> ans = new ArrayList<>();
//         List<String> path = new ArrayList<>();
//         dfs(0, s, path, ans);
//         return ans;
//     }

//     // 现在 s 未被分割的部分为 [i, n-1]
//     // 枚举下一刀切在哪
//     private void dfs(int i, String s, List<String> path, List<List<String>> ans) {
//         if (i == s.length()) { // s 分割完毕
//             ans.add(new ArrayList<>(path)); // 复制 path
//             return;
//         }
//         for (int j = i; j < s.length(); j++) { // 枚举子串的结束位置
//             if (isPalindrome(s, i, j)) { // 判断 [i, j] 是不是回文串
//                 path.add(s.substring(i, j + 1)); // 分割！
//                 // 现在 s 未被分割的部分为 [j+1, n-1]
//                 dfs(j + 1, s, path, ans);
//                 path.removeLast(); // path.remove(path.size() - 1);
//             }
//         }
//     }

//     private boolean isPalindrome(String s, int left, int right) {
//         while (left < right) {
//             if (s.charAt(left++) != s.charAt(right--)) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }