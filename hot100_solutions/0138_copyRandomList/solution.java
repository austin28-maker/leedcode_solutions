/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // 复制每个节点，把新节点直接插到原节点的后面
        for (Node cur = head; cur != null; cur = cur.next.next) {
            // 为什么要 cur.next.next 而不是 cur.next？
            // 因为 cur.next 是新节点，而新节点的 next 是 cur.next.next，所以要跳过 cur.next，直接跳到新节点的 next
            // 也就是说条件判断中的条件是会根据循环内部的执行语句进行更新的？
            cur.next = new Node(cur.val, cur.next);
        }

        // 遍历交错链表中的原链表节点
        for (Node cur = head; cur != null; cur = cur.next.next) {
            if (cur.random != null) { // 为什么要判断一下是否为 null？
            // 因为随机指针指向的节点可能是 null，所以要判断一下是否为 null
            // 如果为 null，就直接把 random 指针设为 null
            // 如果不是 null，就把 random 指针设为 cur.random 的下一个节点
                cur.next.random = cur.random.next;
            }
        }

        // 把交错链表分离成两个链表
        Node dummy = new Node(0);
        Node tail = dummy; // 作用是记录新链表的尾节点
        for (Node cur = head; cur != null; cur = cur.next, tail = tail.next) {
            Node copy = cur.next; // 新节点
            tail.next = copy; // 把新节点插在 tail 的后面，构建新的链表
            cur.next = copy.next; // 恢复原节点的 next
        }

        return dummy.next;
    }
}
