class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:  # 如果没有房屋，返回0
            return 0

        prev_max = 0  # 上一个房屋的最大金额
        curr_max = 0  # 当前房屋的最大金额

        for num in nums:
            temp = curr_max  # 临时变量保存当前房屋的最大金额
            curr_max = max(prev_max + num, curr_max)  # 更新当前房屋的最大金额
            prev_max = temp  # 更新上一个房屋的最大金额

        return curr_max  # 返回最后一个房屋中可抢劫的最大金额