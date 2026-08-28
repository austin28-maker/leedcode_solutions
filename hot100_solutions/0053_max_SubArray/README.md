## 解题思路

- 方法一：动态规划
  - 定义状态：dp[i] 表示以 nums[i] 结尾的最大子数组和
  - 状态转移方程：dp[i] = max(dp[i-1] + nums[i], nums[i])
  - 初始化：dp[0] = nums[0]
  - 结果：max(dp[i])
