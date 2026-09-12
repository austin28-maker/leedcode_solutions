class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        #回溯，建立满二叉树，
        out = []
        def dfs(list_, relist):
            if  len(relist) == len(list_):
                out.append(relist)
            for i in range(len(nums)): # 回溯操作隐藏在dfs中，所以不需要手动回溯
                if nums[i] in relist:
                    continue
                dfs(nums, relist+[nums[i]]) # 注意这里和relist相加的必须也是一个列表类型，所以是[nums[i]]，而不是nums[i]
        dfs(nums, [])
        return out