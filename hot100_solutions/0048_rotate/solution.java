/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 */

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                // 临时变量temp存储当前元素matrix[i][j]的值
                int temp = matrix[i][j];
                // 将matrix[n - 1 - j][i]的值赋给matrix[i][j]
                matrix[i][j] = matrix[n - 1 - j][i];// 顺时针旋转90度
                // 将matrix[n - 1 - i][n - 1 - j]的值赋给matrix[n - 1 - j][i]
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];// 顺时针旋转90度
                // 将matrix[j][n - 1 - i]的值赋给matrix[n - 1 - i][n - 1 - j]
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];// 顺时针旋转90度
                // 将temp的值赋给matrix[j][n - 1 - i]
                matrix[j][n - 1 - i] = temp;    
            }
        }
    }
}
