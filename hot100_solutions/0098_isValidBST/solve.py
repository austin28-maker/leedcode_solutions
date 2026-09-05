class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.isValidBST(root, float('-inf'), float('inf'))
    
    def isValidBST(self, node: TreeNode, left: float, right: float) -> bool:
        if node is None:
            return True
        x = node.val
        return left < x and x < right and \
               self.isValidBST(node.left, left, x) and \
               self.isValidBST(node.right, x, right)