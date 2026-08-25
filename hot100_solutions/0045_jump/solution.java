// 方法一：从后往前的动态规划（README 中的思想）
// step[i] = 从 i 跳到终点的最少步数
// 转移：step[i] = min(step[j]) + 1，j ∈ [i+1, min(n-1, i+nums[i])]
// 特例：i + nums[i] >= n-1 时 step[i] = 1（一步直达终点）
// 时间复杂度 O(n^2)（每个 i 都要扫一遍可跳区间取 min），会超时，仅保留用于理解演变过程
// class Solution {
//     public int jump(int[] nums) {
//         int n = nums.length;
//         int[] step = new int[n];
//         for (int i = n - 2; i >= 0; i--) {
//             if (i + nums[i] >= n - 1) {
//                 step[i] = 1; // 一步直达终点
//             } else {
//                 int mn = Integer.MAX_VALUE;
//                 for (int j = i + 1; j <= i + nums[i]; j++) {
//                     mn = Math.min(mn, step[j]); //这里的step[j]是之前计算过的，因为是从后向前遍历
//                 }
//                 step[i] = mn + 1;
//             }
//         }
//         return step[0];
//     }
// }

// 方法二：正向贪心（由方法一优化而来）
// 优化推导：
//   1. 方法一的本质是"按步数分层"：step 值相同的位置构成一层，每多跳一步就进入下一层
//   2. 第 ans 步能到达的所有位置，是一个连续区间 [区间左端, curEnd]
//      遍历区间内每个位置 i 时，用 i + nums[i] 不断更新"下一步最远能到哪"（mx）
//   3. 当 i 走到 curEnd（当前层的右边界）时，必须再跳一步进入下一层：
//      ans++，新层的右边界 = mx
//   4. 省掉了 min 的逐个比较——只需维护两个变量，O(n) 一趟完成
class Solution {
    public int jump(int[] nums) {
        int ans = 0;
        int curEnd = 0; // 当前这一步能覆盖的最远边界（当前层的右端）
        int mx = 0;     // 下一步能覆盖的最远边界（下一层的右端）
        // 注意循环到 n-2 为止：站在终点上不需要再跳
        for (int i = 0; i < nums.length - 1; i++) {
            mx = Math.max(mx, i + nums[i]); // 站在 i 最远跳到 i+nums[i]
            if (i == curEnd) {              // 走完当前层，必须再跳一步
                // 当前层怎么去理解？
                // 当前层的所有位置，都是在 ans 步能到达的
                // 例如：[2,3,1,1,4]
                // 不是从第一个元素开始跳么？
                ans++;
                curEnd = mx;                // 进入下一层
            }
        }
        return ans;
    }
}