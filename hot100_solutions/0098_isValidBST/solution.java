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
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if (root == null) {
//             return true;
//         }

//         return dfs(root, null, null); // 根节点没有上下界
//     }

//     private boolean dfs(TreeNode root, TreeNode min, TreeNode max) {
//         // 参数含义：
//         // root：当前要检查的节点
//         // min：当前节点的下界（必须 > min.val）
//         // max：当前节点的上界（必须 < max.val）
//         if (root == null) {
//             return true;
//         }
//         if (min != null && root.val <= min.val) {
//             return false;
//         }
//         if (max != null && root.val >= max.val) {
//             return false;
//         }
//         return dfs(root.left, min, root) && dfs(root.right, root, max);
//     }
// }

// 前序遍历
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE); // 根节点没有上下界
    }

    private boolean isValidBST(TreeNode node, long left, long right) { 
        // 参数含义：
        // node：当前要检查的节点
        // left：当前节点的下界（必须 > left）
        // right：当前节点的上界（必须 < right）
        if (node == null) {
            return true;
        }
        long x = node.val;
        return left < x && x < right &&
               isValidBST(node.left, left, x) &&
               isValidBST(node.right, x, right); // 递归检查左右子树是否符合 BST 定义
    }
}