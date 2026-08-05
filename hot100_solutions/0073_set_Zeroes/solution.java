/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法
 */

public class solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // matrix.length 表示行数，matrix[0].length 表示列数
        boolean[] rowZero = new boolean[m], colZero = new boolean[n];
        // 这里的不是初始化么？为什么new后的面的boolean括号加内容？当前只是定义大小，并且m和n都只是数字
        // 因为new boolean[m] 表示创建一个m个元素的boolean数组，每个元素都初始化为false
        // 而new boolean[n] 表示创建一个n个元素的boolean数组，每个元素都初始化为false

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowZero[i] || colZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
