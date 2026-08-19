class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        // 注意：如果target不存在，start可能会指向nums.length，需要特殊处理
        if (start == nums.length || nums[start] != target) {
            return new int[] { -1, -1 };
        }

        int end = lowerBound(nums, target + 1) - 1; // 找到第一个大于target的索引，减1得到结束索引
        return new int[] { start, end };
    }

    // lowerBound函数，返回第一个大于等于target的索引
    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 闭区间写法
        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止溢出
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}