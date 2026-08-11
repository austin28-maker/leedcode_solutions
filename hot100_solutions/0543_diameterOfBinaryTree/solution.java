/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight + rightHeight, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    private int height(TreeNode root){ // private：仅Solution类内部可调用
    // 在Solution类外部创建对象时：能调用public的diameterOfBinaryTree，
    // 不能调用private的height；但在类内部，两者都能自由调用
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));// +1是因为Math.max返回的是左右节点较大的那个值，
        // 根节点和左右节点之间的连线也算作一条边，当然要加上才算做当前根节点的高度
    }
}