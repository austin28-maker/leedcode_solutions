class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        p0 = p1 = 0
        for i, x in enumerate(nums):
            nums[i] = 2
            if x <= 1:
                nums[p1] = 1
                p1 += 1
            if x == 0:
                nums[p0] = 0
                p0 += 1

# 注意事项
# x 是 nums[i] 的一个独立副本，而不是 nums[i] 本身。
# nums[i] = 2 是在修改列表容器中索引 i 位置的指向（让它指向整数对象 2）。
# x 本身不会被修改，因为它是一个独立的变量。