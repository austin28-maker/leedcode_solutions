class Solution:
    def numSquares(self, n: int) -> int:
        dp = [float('inf')] * (n + 1) # 初始化 dp 数组，所有元素设为无穷大
        # 边界条件：dp[0] = 0，因为 0 可以由 0 个完全平方数组成
        # 其他元素设为无穷大，因为初始时，我们不知道如何凑成这些数
        dp[0] = 0
        for i in range(1, n + 1):
            for j in range(1, int(i ** 0.5) + 1):
                dp[i] = min(dp[i], dp[i - j * j] + 1)
        return dp[n]