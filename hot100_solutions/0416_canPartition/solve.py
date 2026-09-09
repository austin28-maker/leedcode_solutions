from typing import List

# 优化前
# class Solution:
#     def canPartition(self, nums: List[int]) -> bool:
#         s = sum(nums)
#         if s % 2:
#             return False
#         s //= 2  # 注意这里把 s 减半了

#         n = len(nums)
#         f = [[False] * (s + 1) for _ in range(n + 1)]
#         f[0][0] = True
#         for i, x in enumerate(nums):
#             for j in range(s + 1):
#                 f[i + 1][j] = j >= x and f[i][j - x] or f[i][j]
#         return f[n][s]

# 优化后
class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        s = sum(nums)
        if s % 2:
            return False
        s //= 2  # 注意这里把 s 减半了

        f = [True] + [False] * s
        s2 = 0
        for i, x in enumerate(nums):
            s2 = min(s2 + x, s) # 注意这里把 s 减半了
            for j in range(s2, x - 1, -1):
                f[j] = f[j] or f[j - x]
            if f[s]:
                return True
        return False