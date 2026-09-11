# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def averageOfSubtree(self, root: TreeNode) -> int:
        ans = 0

        def dfs(node : TreeNode | None) -> tuple[int, int]:
            if node is None:
                return 0, 0
            
            left_sum, left_size = dfs(node.left)
            right_sum, right_size = dfs(node.right)
            sum_ = left_sum + right_sum + node.val
            size_ = left_size + right_size + 1
            if node.val == sum_ // size_:
                nonlocal ans # 非局部变量，需要声明为 nonlocal
                ans += 1
            return sum_, size_
        
        dfs(root)
        return ans