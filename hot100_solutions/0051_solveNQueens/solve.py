class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        ans = []
        queens = [0] * n  # queen[r]表示第r行的皇后放的列数
        col = [False] * n # 记录每列是否已被占领
        diag1 = [False] * (n * 2 - 1) # 记录每条下斜线是否已被占领
        diag2 = [False] * (n * 2 - 1) # 记录每条上斜线是否已被占领
        def dfs(r: int) -> None: # r表示当前行
            if r == n:
                ans.append(['.' * c + 'Q' + '.' * (n - 1 - c) for c in queens])
                return
            # 在 (r,c) 放皇后
            for c, ok in enumerate(col):
                # 当前遍历的是第r行的第c列
                # 判断的是已经放过的皇后所在的行、列以及斜线
                if not ok and not diag1[r + c] and not diag2[r - c]:  # 判断能否放皇后
                    queens[r] = c  # 直接覆盖，无需恢复现场
                    col[c] = diag1[r + c] = diag2[r - c] = True  # 皇后占用了 c 列和两条斜线
                    dfs(r + 1)
                    col[c] = diag1[r + c] = diag2[r - c] = False  # 恢复现场
        dfs(0)
        return ans