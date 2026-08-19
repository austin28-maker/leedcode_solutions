class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int x = matrix[mid / n][mid % n]; // mid/n 是行索引，mid%n 是列索引，n 是列数
            if(x == target){
                return true;
            }else if(x > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}