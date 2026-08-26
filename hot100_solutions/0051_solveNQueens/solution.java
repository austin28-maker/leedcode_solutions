import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] queens = new int[n]; // 皇后放在 (r,queens[r])
        boolean[] col = new boolean[n]; // 列是否被占用
        boolean[] diag1 = new boolean[n * 2 - 1]; // 主对角线是否被占用
        boolean[] diag2 = new boolean[n * 2 - 1]; // 次对角线是否被占用
        dfs(0, queens, col, diag1, diag2, ans);
        return ans;
    }

    private void dfs(int r, int[] queens, boolean[] col, boolean[] diag1, boolean[] diag2, List<List<String>> ans) {
        int n = col.length;

        // 递归结束条件：r == n 时，所有行都放了皇后
        if (r == n) {
            List<String> board = new ArrayList<>(n); // 预分配空间
            for (int c : queens) {
                char[] row = new char[n];
                Arrays.fill(row, '.'); // Arrays.fill的作用是将数组的所有元素都设为指定值，这里设为 '.' 表示空位
                row[c] = 'Q';
                board.add(new String(row)); // 这里需要new
            }
            ans.add(board); // 这里不用new
            return;
        }
        // 在 (r,c) 放皇后
        for (int c = 0; c < n; c++) {
            int rc = r - c + n - 1;
            if (!col[c] && !diag1[r + c] && !diag2[rc]) { // 判断能否放皇后
                queens[r] = c; // 直接覆盖，无需恢复现场
                col[c] = diag1[r + c] = diag2[rc] = true; // 皇后占用了 c 列和两条斜线
                dfs(r + 1, queens, col, diag1, diag2, ans);
                col[c] = diag1[r + c] = diag2[rc] = false; // 回溯是为了求解所有解
            }
        }
    }
}