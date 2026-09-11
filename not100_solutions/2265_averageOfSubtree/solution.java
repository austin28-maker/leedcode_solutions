class Solution {
    private int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0}; // 递归边界：空节点返回[0, 0]
        }
        int[] left = dfs(node.left); // 拆解问题：递归计算左子树的信息
        int[] right = dfs(node.right); // 拆解问题：递归计算右子树的信息
        int sum = left[0] + right[0] + node.val; // node 子树的节点值之和
        int size = left[1] + right[1] + 1; // node 子树的节点个数
        if (node.val == sum / size) { // 题目要求下取整
            ans++;
        }
        return new int[]{sum, size};
    }
}