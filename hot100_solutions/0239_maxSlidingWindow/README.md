## 知识点

- 队列
    - .peekFirst() 方法返回 deque 中第一个元素，不删除
    - .removeFirst() 方法删除 deque 中第一个元素
    - .peekLast() 方法返回 deque 中最后一个元素，不删除
    - .removeLast() 方法删除 deque 中最后一个元素
    - .addLast() 方法在 deque 的末尾添加一个元素
    - .isEmpty() 方法判断 deque 是否为空

## 解题思路

- 用一个双端队列 deque 来维护窗口内的最大值
- 每次滑动窗口时，都删除 deque 中对应的 nums[i-1]
- 保持 deque 递减
- 记录窗口最大值
    - 窗口最大值就是 deque 中的第一个元素