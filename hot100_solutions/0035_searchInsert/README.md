## 解题思路

- 方法一（不推荐）：暴力法，遍历数组，时间复杂度为O(n)，空间复杂度为O(n)

- 方法二：二分查找，时间复杂度为O(logn)，空间复杂度为O(1)
    - 套路模板为：
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                （填写）
            } else if (nums[mid] < target) {
                （填写）
            } else {
                （填写）
            }
        }
        return （填写）;