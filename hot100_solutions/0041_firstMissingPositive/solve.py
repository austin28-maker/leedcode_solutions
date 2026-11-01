class Solution:
    def firstMissingPositive(self, nums: list[int]) -> int:
        n = len(nums)
        for i in range(n):
            while nums[i] >= 1 and nums[i] <= n and nums[nums[i] - 1] != nums[i]:
                j = nums[i] - 1
                # temp = nums[i]
                # nums[i] = nums[j]
                # nums[j] = temp
                nums[i], nums[j] = nums[j], nums[i]
        
        for i in range(n):
            if nums[i] != i + 1:
                return i + 1
        
        return n + 1