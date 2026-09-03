class Solution:
    def uniformArray(self, nums1: List[int]) -> bool:
        # 计算最小偶数、最小奇数
        mn = [inf] * 2
        for x in nums1:
            mn[x & 1] = min(mn[x & 1], x) # &1 比 %2 好，nums1 有负数也适用
        
        # 只有偶数，或者偶数 >= 最小的偶数 > 最小的奇数
        # 只有奇数的情况蕴含在 mn[0] > mn[1] 中
        return mn[1] == inf or mn[0] > mn[1]
