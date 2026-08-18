
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int count = 0; // count 表示新鲜橘子的数量
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    count++;
                } else if (grid[r][c] == 2) {
                    queue.add(new int[] { r, c }); // {r, c} 表示腐烂的橘子的坐标，所以这个new的数组元素是{r, c}，而不是r或c本身
                }
            }
        }

        int round = 0; // round 表示腐烂的轮数，或者分钟数
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int n = queue.size(); // 正因为poll() 方法每次只吐一个数组对象，所以这里要先记录下当前队列的大小，表示当前执行层的腐烂橘子数量
            // 这些腐烂的橘子属于同一批次扩散，所以要一次遍历完，才能更新下一批次的腐烂橘子
            for (int i = 0; i < n; i++) {
                int[] orange = queue.poll(); // .poll() 方法返回队头元素，同时从队列中移除
                // add(...) 只能塞 int[] 进去
                // .poll() 吐出来的也一定是 int[] 类型
                int r = orange[0];
                int c = orange[1];
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    count--;
                    queue.add(new int[] { r - 1, c });
                }
                if (r + 1 < M && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    count--;
                    queue.add(new int[] { r + 1, c });
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    count--;
                    queue.add(new int[] { r, c - 1 });
                }
                if (c + 1 < N && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    count--;
                    queue.add(new int[] { r, c + 1 });
                }
            }
        }

        if (count > 0) {
            return -1;
        } else {
            return round;
        }
    }
}