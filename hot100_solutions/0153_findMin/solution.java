// 开区间 (-1, n-1)
// class Solution {
//     public int findMin(int[] nums) {
//         int n = nums.length;
//         int left = -1;
//         int right = n - 1; // 开区间 (-1, n-1)
//         while (left + 1 < right) { // 开区间不为空
//             int mid = (left + right) >>> 1; // >>> 1 等价于 / 2，但是更高效
//             if (nums[mid] < nums[n - 1]) {
//                 right = mid;
//             } else {
//                 left = mid;
//             }
//         }
//         return nums[right];
//     }
// }

// 闭区间 [0, n-1]
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        
        while(left <= right){
            // int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1;
            if(nums[mid] <= nums[n - 1]){ // 这里必须是 <= ，否则会越界
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return nums[left];
    }
}