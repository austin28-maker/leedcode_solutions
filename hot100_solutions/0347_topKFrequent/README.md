## 解题思路

- 先使用哈希表统计每个元素出现的次数
- 桶排序的使用
    - 先统计每个元素出现的次数
    - 然后把出现次数相同的元素，放到同一个桶中
    - 最后倒序遍历桶，把出现次数前K大的元素加入答案

## 知识点

- 哈希表的使用
    - HashMap的getOrDefault方法
        - 如果键x存在，就返回它的值；如果键x不存在，就返回默认值defaultValue
    - HashMap的merge方法
        - .merge(x, 1, Integer::sum)方法：如果键x存在，就用值1加到它的值上；如果键x不存在，就用值1初始化它
        - .merge(x, 1, Integer::max)方法：如果键x存在，就用值1和它的值取较大值；如果键x不存在，就用值1初始化它
        - .merge(x, 1, Integer::min)方法：如果键x存在，就用值1和它的值取较小值；如果键x不存在，就用值1初始化它
    - HashMap的entrySet方法
        - 返回一个Set<Map.Entry<Integer, Integer>>集合，集合中的元素是cnt表中每个键值对的Map.Entry对象

    - HashMap的values方法
        - 返回一个Collection<Integer>集合，集合中的元素是cnt表中每个键的值
        - 注意：cnt.values()方法返回的是一个Set<Integer>集合，而不是一个List<Integer>集合

    - Map.Entry表示的是键值类型，例如Map.Entry<Integer, Integer>表示的是键是Integer，值是Integer的键值对
        - Map.Entry对象的getKey方法：返回键x
        - Map.Entry对象的getValue方法：返回值cnt[x]的出现次数

- Collections.max方法
    - 如果集合s为空，就返回null；否则，就返回集合s中的最大值
    - 注意：集合s必须是可比较的，例如List<Integer>、Set<Integer>等
    - 本题代码中，我们使用了cnt.values()方法，返回一个Set<Integer>集合，集合中的元素是cnt表中每个键的值
- Collections.min方法
    - 如果集合s为空，就返回null；否则，就返回集合s中的最小值

- 桶排序的使用

- Arrays.setAll(buckets, _ -> new ArrayList<>());
    - 给数组的每个格子都装上一个空 ArrayList，用于存储出现次数相同的元素
    - 等价于
    ```java
        for (int i = 0; i <= maxCnt; i++) {
            buckets[i] = new ArrayList<>();
        }
    ```