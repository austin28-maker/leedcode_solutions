## 解题思路

- 先对 nums 进行排序，得到 pos 数组，pos[i] 表示 nums 中第 i 个元素的索引。
- 然后遍历 pos 数组，每次遇到一个段落（即 nums[pos[i]] 到 nums[pos[i+1]] 之间的差值大于等于 limit），就将 pos 数组中从 start 到 i 的元素从小到大填入 ans 数组中。
- 最后返回 ans 数组。

- 看不懂，也没看懂