/**
 * 你正在维护一个项目，该项目有 n 个方法，编号从 0 到 n - 1。

给你两个整数 n 和 k，以及一个二维整数数组 invocations，其中 invocations[i] = [ai, bi] 表示方法 ai 调用了方法 bi。

已知如果方法 k 存在一个已知的 bug。那么方法 k 以及它直接或间接调用的任何方法都被视为 可疑方法 ，我们需要从项目中移除这些方法。

只有当一组方法没有被这组之外的任何方法调用时，这组方法才能被移除。

返回一个数组，包含移除所有 可疑方法 后剩下的所有方法。你可以以任意顺序返回答案。如果无法移除 所有 可疑方法，则 不 移除任何方法。
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int m = invocations.length;
        int[] head = new int[n], nxt = new int[m];
        Arrays.fill(head, -1);
        for (int i = 0; i < m; ++i) {
            int u = invocations[i][0];
            nxt[i] = head[u];
            head[u] = i;
        }
        int[] q = new int[n];
        boolean[] vis = new boolean[n];
        int s = 0, e = -1;
        vis[q[++e] = k] = true;
        while (s <= e) {
            int u = q[s++];
            for (int i = head[u]; i > -1; i = nxt[i]) {
                int v = invocations[i][1];
                if (!vis[v]) vis[q[++e] = v] = true;
            }
        }
        Arrays.fill(head, -1);
        for (int i = 0; i < m; ++i) {
            int v = invocations[i][1];
            nxt[i] = head[v];
            head[v] = i;
        }
        List<Integer> ans = new ArrayList<>(n);
        for (int v = 0; v < n; ++v) {
            if (!vis[v]) {
                ans.add(v);
                continue;
            }
            for (int i = head[v]; i > -1; i = nxt[i]) {
                int u = invocations[i][0];
                if (!vis[u]) {
                    ans.clear();
                    for (int z = 0; z < n; ++z) ans.add(z);
                    return ans;
                }
            }
        }
        return ans;
    }
}