/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
import java.util.ArrayList;
import java.util.List;

public class solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        }

        // 定义四个边界，分别表示矩阵的上、下、左、右边界
        // 初始化时，上边界为0，下边界为m-1，左边界为0，右边界为n-1
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        while (top <= bottom && left <= right) {// 上下左右边界和我的题目有什么关系？
            // 上边界和下边界表示矩阵的上下边界，左边界和右边界表示矩阵的左右边界
            // 每次循环，都需要更新这四个边界，将当前边界加入到结果列表中
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) {
                break;// break直接跳出while循环还是for循环呢？
                // 因为while循环是判断边界是否超出范围，所以break跳出while循环
            }
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return res;
    }
}