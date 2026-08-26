## 解题思路

- 动态规划
    - 状态转移方程：memo[i] = min{memo[i-coin[j]] + 1}，其中0 <= j < coins.length
    - 边界条件：memo[0] = 0，memo[i] = Integer.MAX_VALUE，其中i > 0
    - 返回memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount]