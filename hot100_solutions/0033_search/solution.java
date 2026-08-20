class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;

            // 左半段有序 例如[4 5 6 7 8 1 2] mid是7，左半边456是有序的
            if (nums[left] <= nums[mid]) {
                // target 在 [nums[left], nums[mid-1]] 内
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else { // target 在右边 [nums[mid+1], nums[right]]
                    left = mid + 1;
                }
            } else { // 右半段有序 例如[4 5 1 2 3 4 5] mid是2，右半边345是有序的
                // target 在 [nums[mid+1], nums[right]] 内
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else { // target在左半边
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}