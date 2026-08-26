import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

        int res = 0;

        int[] newHeights = new int[len + 2]; // 加入哨兵，避免额外的判断，即在数组首尾各添加一个0高度
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len); // 复制原始数组到新数组的中间部分
        // 该语句的语法结构是：
        // System.arraycopy(源数组，源数组的起始位置，目标数组，目标数组的起始位置，复制的元素个数)

        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);
        
        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) { // 当前高度小于栈顶高度，说明当前高度是栈顶高度的右边第一个小于当前高度的高度
                int curHeight = heights[stack.pollLast()]; // 弹出栈顶高度
                int curWidth = i - stack.peekLast() - 1; // 当前高度的宽度就是栈顶高度的右边第一个小于当前高度的下标减去栈顶高度的左边第一个小于当前高度的下标减1
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i); // 注意，这里要入栈的是当前高度的下标，而不是当前高度本身
        }
        return res;
    }
}