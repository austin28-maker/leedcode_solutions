# 方法一：动态规划
# def lengthOfLIS(self, nums: List[int]) -> int:
#     if not nums:
#         return 0
#     dp = [1] * len(nums)
#     for i in range(1, len(nums)):
#         for j in range(i):
#             if nums[i] > nums[j]:
#                 dp[i] = max(dp[i], dp[j] + 1)
#     return max(dp)

# 方法二：动态规划 + 二分查找
def lengthOfLIS(self, nums: List[int]) -> int:
    if not nums:
        return 0
    dp = [nums[0]]
    for i in range(1, len(nums)):
        if nums[i] > dp[-1]:
            dp.append(nums[i])
        else:
            left = 0
            right = len(dp) - 1
            while left <= right:
                mid = left + (right - left) // 2
                if dp[mid] >= nums[i]:
                    right = mid - 1
                else:
                    left = mid + 1
            dp[left] = nums[i]
    return len(dp)