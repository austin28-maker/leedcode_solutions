import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>(); // 栈，用于存储节点指针
        while (root != null || !stack.isEmpty()) {
            while (root != null) { // 只要root不为空，就一直遍历左子树将所有左节点压入栈顶
                stack.push(root); // .push()方法将元素压入栈顶
                root = root.left; 
            }

            // 此时左子树遍历完成，先考虑找栈顶元素是否是第k小的节点
            // 如果是，就返回栈顶元素的值
            // 如果不是，就继续遍历右子树
            root = stack.pop(); // .pop()方法弹出栈顶元素

            // 利用k记录当前遍历到的节点的排名，初始值为k，直至k=0，说明已经找到第k小的节点
            // 反之，k≠0或者大于0，都说明当前节点不是第k小的节点，继续遍历右子树
            --k; // --k和k--的区别是，--k是先减1，再赋值给k，而k--是先赋值给k，再减1
            if (k == 0) {
                break; // 跳出while循环，说明已经找到第k小的节点
            }
            root = root.right; // 如果遍历了左子树都没有找到第k小的节点，就遍历右子树
        }
        return root.val;
    }
}