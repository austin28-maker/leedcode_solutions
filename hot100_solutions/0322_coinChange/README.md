## 解题思路

- 动态规划
    - 状态转移方程：memo[i] = min{memo[i-coin[j]] + 1}，其中0 <= j < coins.length
    - 边界条件：memo[0] = 0，memo[i] = Integer.MAX_VALUE，其中i > 0
    - 返回memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount]

## 二编

- 和279题目类似，都是求最小的组合数
    - 需要将dp[i]初始化为最大值，因为初始时，我们不知道如何凑成这些数
    - 这样dp[i]在递推的时候才不会被初始值覆盖
- 2次for循环不太理解
    - 第一次for循环是遍历所有硬币，第二次for循环是遍历所有金额