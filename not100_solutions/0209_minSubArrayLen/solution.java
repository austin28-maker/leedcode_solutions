class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = n + 1; // 初始化答案为 n + 1，大于数组长度
        // 如果没有符合条件的子数组，ans 会保持为 n + 1，最后返回 0
        int sum = 0; // 子数组元素和
        int left = 0; // 子数组左端点
        for (int right = 0; right < n; right++) { // 枚举子数组右端点
            sum += nums[right];
            while (sum - nums[left] >= target) { // 尽量缩小子数组长度
                sum -= nums[left];
                left++; // 左端点右移
            }
            if (sum >= target) {
                ans = Math.min(ans, right - left + 1);
            }
        }
        return ans <= n ? ans : 0;
    }
}