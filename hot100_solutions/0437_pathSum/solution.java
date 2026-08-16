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

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        // 前缀和思想

        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        prefix.put(0L, 1); // 0L中的L表示这是一个Long类型的0，而不是Integer类型的0
        // 这是为了处理根节点到当前节点的路径和为targetSum的情况，
        // 因为根节点的前缀和为0，而targetSum也为0，所以需要将0L的出现次数设为1

        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        // 前缀和可能达到 10^12（节点值最大10^9 × 最多1000个节点），超出 int 范围会溢出，所以用 long 类型

        if (root == null) {
            return 0;
        }

        int ret = 0;

        // 计算当前节点的前缀和
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1); // .put()方法表示更新前缀和的出现次数，
        // 如果前缀和curr不存在，就设为0，再加1，否则就加1

        // 递归遍历左右子树
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1); // 这里为什么要减1？
        // 因为当前节点的前缀和curr已经遍历过了，所以需要减1，
        // 否则会在后续的递归中重复计算

        return ret;
    }
}