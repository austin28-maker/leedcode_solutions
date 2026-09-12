class Solution:
    def trap(self, height: List[int]) -> int:
        ans = pre_max = suf_max = 0
        left, right = 0, len(height) - 1
        while left < right:
            pre_max = max(pre_max, height[left])  # 前缀最大值
            suf_max = max(suf_max, height[right])  # 后缀最大值
            if pre_max < suf_max:  # 可以确定 left 处的接水量
                ans += pre_max - height[left]
                left += 1  # 搞定了 left，现在问题缩小到 [left+1, right]
            else:  # 可以确定 right 处的接水量
                ans += suf_max - height[right]
                right -= 1  # 搞定了 right，现在问题缩小到 [left, right-1]
        return ans

# class Solution:
#     def trap(self, height: List[int]) -> int:
#         n = len(height)
#         pre_max = [0] * n  # pre_max[i] 表示从 height[0] 到 height[i] 的最大值
#         pre_max[0] = height[0]
#         for i in range(1, n):
#             pre_max[i] = max(pre_max[i - 1], height[i])

#         suf_max = [0] * n  # suf_max[i] 表示从 height[i] 到 height[n-1] 的最大值
#         suf_max[-1] = height[-1]
#         for i in range(n - 2, -1, -1):
#             suf_max[i] = max(suf_max[i + 1], height[i])

#         ans = 0
#         # 怎么理解Python中的zip函数？
#         # zip函数可以将多个可迭代对象打包成一个元组序列
#         # 每个元组的长度与最短的可迭代对象的长度相同
#         # 当可迭代对象的长度不同时，zip函数会自动截断
#         # 例如：zip([1, 2, 3], [4, 5, 6, 7]) 会返回 [(1, 4), (2, 5), (3, 6)]
#         for h, pre, suf in zip(height, pre_max, suf_max):
#             ans += min(pre, suf) - h  # 累加每个水桶能接多少水
#         return ans