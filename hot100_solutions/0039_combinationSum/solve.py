class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result =[]
        candidates.sort()
        self.backtracking(candidates, target, 0, [], result) # 递归函数的模板
        return result

    def backtracking(self, candidates, target, startIndex, path, result):
        if target == 0:
            result.append(path[:])
            return

        for i in range(startIndex, len(candidates)):
            if target - candidates[i]  < 0:
                break # 剪枝一：排序之后，如果当前元素大于目标值，后续元素都大于目标值，无需继续遍历。
            path.append(candidates[i]) 
            self.backtracking(candidates, target - candidates[i], i, path, result)
            path.pop() # 回溯，撤销选择