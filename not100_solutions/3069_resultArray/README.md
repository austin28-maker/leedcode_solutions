## 思路

- 用两个数组 a 和 b 分别存储 nums 中的元素
- 遍历 nums，如果 a 中最后一个元素大于 b 中最后一个元素，就将 nums 中的元素添加到 a 中，否则添加到 b 中
- 最后将 a 和 b 合并，返回合并后的数组

## 知识点

- 列表的合并
- 列表的方法：
  - add(int index, E element)
  - get(int index)
  - size()
  - addAll(Collection<? extends E> c)
  - set(int index, E element)
  - remove(int index)
  - clear()