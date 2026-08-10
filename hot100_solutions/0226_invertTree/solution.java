class Solution {
    // 先序遍历--从顶向下交换
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        // 保存右子树
        TreeNode rightTree = root.right;
        // 交换左右子树的位置
        root.right = invertTree(root.left);
        // invertTree(root.left)返回的是交换后的左子树

        root.left = invertTree(rightTree);
        return root;
    }
}