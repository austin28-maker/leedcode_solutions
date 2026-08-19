import java.util.LinkedHashMap;
import java.util.Map;

// 方法一：标准库 LinkedHashMap
class LRUCache {
    private final int capacity; // final修饰符，表示 capacity 是常量，不能被修改
    private final Map<Integer, Integer> cache = new LinkedHashMap<>(); // 内置 LRU

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        // 删除 key，并利用返回值判断 key 是否在 cache 中
        Integer value = cache.remove(key); // .remove 方法会返回被删除的值
        if (value != null) { // key 在 cache 中
            cache.put(key, value); // .put 方法会更新链表顺序，将 key 放到链表头位置
            return value;
        }
        // key 不在 cache 中
        return -1;
    }

    public void put(int key, int value) {
        // 删除 key，并利用返回值判断 key 是否在 cache 中
        if (cache.remove(key) != null) { // key 在 cache 中
            cache.put(key, value);
            return;
        }
        // key 不在 cache 中，那么就把 key 插入 cache，插入前判断 cache 是否满了
        if (cache.size() == capacity) { // cache 满了
            Integer eldestKey = cache.keySet().iterator().next();
            // .keySet() 方法会返回 cache 中所有 key 的集合
            // .iterator() 方法会返回集合的迭代器，迭代器表示沿这条链表从头走到尾
            // .next() 方法会返回集合的第一个元素
            // .remove() 方法会移除集合的第一个元素
            // 所以，以上代码的作用是移除集合的第一个元素，即最久未使用的 key
            // 第一个元素是链表头，链表头就是最久未使用的 key

            cache.remove(eldestKey); // 移除最久未使用 key
        }
        cache.put(key, value);
    }
}

// 方法二：手动实现双向链表和哈希表
// class LRUCache {
//     private static class Node {
//         int key, value;
//         Node prev, next;

//         Node(int k, int v) {
//             key = k;
//             value = v;
//         }
//     }

//     private final int capacity;
//     private final Node dummy = new Node(0, 0); // 哨兵节点
//     private final Map<Integer, Node> keyToNode = new HashMap<>();

//     public LRUCache(int capacity) {
//         this.capacity = capacity;
//         dummy.prev = dummy;
//         dummy.next = dummy;
//     }

//     public int get(int key) {
//         Node node = getNode(key); // getNode 会把对应节点移到链表头部
//         return node != null ? node.value : -1;
//     }

//     public void put(int key, int value) {
//         Node node = getNode(key); // getNode 会把对应节点移到链表头部
//         if (node != null) { // 有这本书
//             node.value = value; // 更新 value
//             return;
//         }
//         node = new Node(key, value); // 新书
//         keyToNode.put(key, node);
//         pushFront(node); // 放到最上面
//         if (keyToNode.size() > capacity) { // 书太多了
//             Node backNode = dummy.prev;
//             keyToNode.remove(backNode.key);
//             remove(backNode); // 去掉最后一本书
//         }
//     }

//     // 获取 key 对应的节点，同时把该节点移到链表头部
//     private Node getNode(int key) {
//         if (!keyToNode.containsKey(key)) { // 没有这本书
//             return null;
//         }
//         Node node = keyToNode.get(key); // 有这本书
//         remove(node); // 把这本书抽出来
//         pushFront(node); // 放到最上面
//         return node;
//     }

//     // 删除一个节点（抽出一本书）
//     private void remove(Node x) {
//         x.prev.next = x.next;
//         x.next.prev = x.prev;
//     }

//     // 在链表头添加一个节点（把一本书放到最上面）
//     private void pushFront(Node x) {
//         x.prev = dummy;
//         x.next = dummy.next;
//         x.prev.next = x;
//         x.next.prev = x;
//     }
}