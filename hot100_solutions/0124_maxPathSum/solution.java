class Solution {
    private int ans = Integer.MIN_VALUE; // Integer.MIN_VALUE表示最小整数，用于初始化最大路径和

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0; // 没有节点，和为 0
        }
        int sumL = dfs(node.left); // 左子树最大链和
        int sumR = dfs(node.right); // 右子树最大链和
        ans = Math.max(ans, sumL + node.val + sumR); // 左链 + node + 右链 = 路径
        return Math.max(Math.max(sumL, sumR) + node.val, 0); // 当前子树最大链和（注意这里和 0 取最大值了）
    }
}