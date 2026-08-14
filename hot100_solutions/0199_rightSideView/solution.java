import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    // dfs 函数无返回值，那它的作用是什么？
    // 它的作用是遍历二叉树的每个节点，记录下层的第一个节点。
    private void dfs(TreeNode root, int depth, List<Integer> ans) {
        if (root == null) return; // 这里return后面没有语句，说明dfs函数没有返回值
        // 主要是为了终止递归，避免空指针异常

        // 如果当前节点所在的这一层，还没有记录过节点，就记录当前节点。
        if (depth == ans.size()) {
            ans.add(root.val);
        }
        dfs(root.right, depth + 1, ans);
        dfs(root.left, depth + 1, ans);
    }
}