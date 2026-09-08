from typing import List

# # 库函数的方法
# class Solution:
#     def findKthLargest(self, nums: List[int], k: int) -> int:
#         return sorted(nums)[len(nums) - k]

# 快速选择算法
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return self.quickSelect(nums, k)
    
    def quickSelect(self, nums: List[int], k: int) -> int:
        # 随机选择基准数
        rand = random.Random()
        pivot = nums[rand.randint(0, len(nums) - 1)]
        
        # 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中
        big = []
        equal = []
        small = []
        for num in nums:
            if num > pivot:
                big.append(num)
            elif num < pivot:
                small.append(num)
            else:
                equal.append(num)
        # 第 k 大元素在 big 中，递归划分
        if k <= len(big):
            return self.quickSelect(big, k)
        # 第 k 大元素在 small 中，递归划分
        if len(nums) - len(small) < k:
            return self.quickSelect(small, k - len(nums) + len(small))
        # 第 k 大元素在 equal 中，直接返回 pivot
        return pivot