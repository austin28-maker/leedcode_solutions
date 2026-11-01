## 思路

- 回溯算法

## 二编

- 求`组合`、`集合`不考虑顺序，而`排列`考虑顺序
    - 子集也是一种组合问题，因为它的集合是无序的，子集{1,2} 和 子集{2,1}是一样的
    - 既然是无序，取过的元素不会重复取，写回溯算法的时候，for就要从`startIndex`开始，而不是从0开始！

- Java 的 List 接口没有 append 方法，只能使用 add 方法
- append 常见于 StringBuilder / StringBuffer，或者 Python 的 list.append()