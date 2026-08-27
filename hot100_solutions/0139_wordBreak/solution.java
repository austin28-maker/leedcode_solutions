import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        Set<String> words = new HashSet<>(wordDict); // 优化：使用 HashSet 存储 wordDict，提高查询效率
        //  HashSet 的容量和wordDict的相同么？是的。

        int n = s.length();
        boolean[] f = new boolean[n + 1]; // f[i] 表示 s 的前 i 个字符是否可以被 wordDict 中的单词组成
        f[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(i - maxLen, 0); j--) {
                if (f[j] && words.contains(s.substring(j, i))) { // 优化：只检查长度小于等于maxLen的子字符串
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}