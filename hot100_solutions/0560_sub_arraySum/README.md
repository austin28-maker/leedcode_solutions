## 知识点

- 哈希表的使用
    - .getOrDefault(key, defaultValue) 方法表示如果key存在，返回对应的value，否则返回defaultValue
    - .put(key, value) 方法表示将key对应的value设置为value

## 解题思路

- 前缀和思想
    - 遍历数组nums，计算当前子数组的和sum
    - 如果sum - k在map中，就说明存在一个子数组的和为k，所以就将map中sum - k的值加入到结果中，
    - 然后将sum加入到map中，出现次数加1
    - 最后返回结果

- 一般HashMap的运用都是在理清楚了解题思路后为考虑空间复杂度采取的一种优化措施
    并非最开始就想到用HashMap

## 注意事项

- 前缀和思想就是利用数组从头开始加
- sum - (历史某个 sum) 切出的正是中间一段的和
- 为什么要计算sum - k的值
    - 因为sum - (sum - k) = k
    - sum是当前子数组的前缀和，
    - 而sum - k是历史某个子数组的前缀和，
    - 所以sum - (sum - k) = k，就是中间一段的和