class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        // n <= 30 每一行可以用32位整型存储, 方便左移右移操作
        int[] s = new int[n], t = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                s[i] |= img1[i][j] << j;
                t[i] |= img2[i][j] << j;
            }
        }
        int ans = 0;
        for (int dx = 1 - n; dx < n; ++dx) { // 行偏移量
            for (int dy = 1 - n; dy < n; ++dy) { // 列偏移量
                int nowAns = 0;
                int from = Math.max(-dx, 0), to = Math.min(n - dx, n);
                for (int i = from; i < to; ++i) {
                    // 统计 s[i + dx] 左移或者右移dy位后 按位与 t[i] 中1的数量
                    if (dy >= 0) {
                        nowAns += Integer.bitCount(s[i + dx] << dy & t[i]);
                    } else {
                        nowAns += Integer.bitCount(s[i + dx] >> -dy & t[i]);
                    }
                }
                ans = Math.max(ans, nowAns);
            }
        }
        return ans;
    }
}