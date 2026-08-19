## 注意事项

- 数组非递减表示nums[i] <= nums[j]，其中i <= j
- 针对闭区间、半开半闭区间、开区间三种写法，注意理解索引的应用
- 二分查找的返回值left或right，根据题目要求选择不同的返回值
- 理解起始索引和结束索引的求解思路
- 二分查找中的mid索引需要写在while循环体中

## 解题思路

- 二分查找
    - 先使用lowerBound函数找到第一个大于等于target的索引start
    - 然后使用lowerBound函数找到第一个大于target的索引end，减1得到结束索引
    - 返回[start, end]作为结果
    - 注意：如果target不存在，start可能会指向nums.length，需要特殊处理
