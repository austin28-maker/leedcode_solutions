## 解题思路

- 数组
    - 从右到左找到第一个小于 nums[i+1] 的数 nums[i]
    - 从右到左找到 nums[i] 右边最小的大于 nums[i] 的数 nums[j]
    - 交换 nums[i] 和 nums[j]
    - 反转 [i+1, n-1]（如果上面跳过第二步，此时 i = -1）