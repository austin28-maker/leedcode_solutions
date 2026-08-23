## 解题思路

- 贪心算法
    - 从左到右遍历数组，维护一个最小价格 cost 和一个利润 profit。
    - 每次遍历到一个价格 price，更新 cost 为 price 的最小值，更新 profit 为 price - cost 的最大值。
    - 最后返回 profit 即可。

## 注意事项

- 不用比较profit和0的大小，因为profit 从出生起就永远不可能小于 