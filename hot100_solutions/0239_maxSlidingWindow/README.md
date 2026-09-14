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

## 二编

- 队列是双端队列，所以可以从队头和队尾添加元素，
    - 单调栈 实现了随意入栈、出栈情况下的 O(1) 时间获取 “栈内最小值”

- 核心思路
    - 每次遍历到一个新值时，要做一个事情，删除队列中所有比这个值小的值，
    - 因为这个值入队之后，所以比这个值小的，并且在这个值之前的，都不可能是答案。

- Python 通过 zip(range(), range()) 可实现滑动窗口的左右边界 i, j 同时遍历
    - 例如：for i, j in zip(range(n), range(n-k, n)):
    - 这里 i 是窗口的左边界，j 是窗口的右边界

- deque = collections.deque() 初始化一个双端队列 deque

- 注意区分append和add的使用场景
    - append在队列deque、列表list中使用
        - append() 方法在队列、列表`队尾`添加一个元素
        - appendleft() 方法在队列、列表`队头`添加一个元素
    - add在栈stack、集合set中使用