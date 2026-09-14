# 枚举下一个左括号的位置
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        path = []  # 记录左括号的下标

        # 目前填了 i 个括号
        # balance = 这 i 个括号中的左括号个数 - 右括号个数
        def dfs(i: int, balance: int) -> None:
            if len(path) == n:
                s = [')'] * (n * 2)
                for j in path:
                    s[j] = '('
                ans.append(''.join(s))
                return
            # 枚举填 right=0,1,2,...,balance 个右括号
            for right in range(balance + 1):
                # 先填 right 个右括号，然后填 1 个左括号，记录左括号的下标 i+right
                path.append(i + right)
                dfs(i + right + 1, balance - right + 1)
                path.pop()  # 恢复现场
                # 这里的pop()表示恢复现场，将 path 中的最后一个元素弹出，即上一个填的右括号的下标，准备填下一个右括号的下标。
                # path是先入后出的，所以这里需要弹出的是上一个填的右括号的下标。
                # 先入后出的数据结构是栈。

        dfs(0, 0)
        return ans

# 动态规划
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0:
            return []
        total_l = []
        total_l.append([None])    # 0组括号时记为None
        total_l.append(["()"])    # 1组括号只有一种情况
        for i in range(2,n+1):    # 开始计算i组括号时的括号组合
            l = []        
            for j in range(i):    # 开始遍历 p q ，其中p+q=i-1 , j 作为索引
                now_list1 = total_l[j]    # p = j 时的括号组合情况
                now_list2 = total_l[i-1-j]    # q = (i-1) - j 时的括号组合情况
                for k1 in now_list1:  
                    for k2 in now_list2:
                        if k1 == None:
                            k1 = ""
                        if k2 == None:
                            k2 = ""
                        el = "(" + k1 + ")" + k2
                        l.append(el)    # 把所有可能的情况添加到 l 中
            total_l.append(l)    # l这个list就是i组括号的所有情况，添加到total_l中，继续求解i=i+1的情况
        return total_l[n]