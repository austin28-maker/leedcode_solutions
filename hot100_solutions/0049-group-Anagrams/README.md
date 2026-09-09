## 解题思路

- 哈希表分组
    - 先对每个字符串进行排序，然后将排序后的字符串作为键，将原始字符串作为值，存储到哈希表中。
    - 最后，将哈希表中的值转换为列表，返回。

## 知识点

- 哈希表的使用
    - .values() 方法：返回哈希表中所有值的集合。m.values() 的返回类型是 Collection<List<String>>
    - .computeIfAbsent() 方法：如果哈希表中不存在指定的键，则插入一个新的值。
        - 如果哈希表中存在指定的键，则返回该键对应的值。
        - 如果哈希表中不存在指定的键，则调用提供的函数，将返回值作为新键的值插入到哈希表中。
        - 返回新键的值。

## 注意事项

- 为什么要new一个ArrayList<>()，而不是直接return m.values()
    - 因为 m.values() 返回的是一个 Collection<List<String>>，而我们需要的是一个 List<List<String>>。
    - 所以，我们需要将 Collection 转换为 List。
    - 可以使用 ArrayList 构造函数，将 Collection 转换为 ArrayList。
    - 最后，返回 ArrayList。

- Python中 sorted(s) 返回的不是字符串，而是字符列表。
    - 所以，我们需要使用 join() 方法，将字符列表转换为字符串。
    - 这里用空字符串连接，所以结果就是排序后的字符串。