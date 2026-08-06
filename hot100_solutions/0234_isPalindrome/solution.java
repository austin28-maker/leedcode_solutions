/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */

class Solution {
    public boolean isPalindrome(ListNode head) {
        // 回文链表
        if (head == null || head.next == null) {
            return true;
        }
        // 找到链表的中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {// 快指针不为空，且快指针的下一个节点也不为空
            slow = slow.next;
            fast = fast.next.next;
        }
        // 将链表反转
        // 反转的逻辑是什么？
        // 1. 先定义一个前驱节点prev，指向null
        // 2. 定义一个当前节点cur，指向slow
        // 3. 定义一个后节点next，指向cur的下一个节点
        // 4. 将cur的下一个节点指向prev
        // 5. 将prev指向cur
        // 6. 将cur指向next
        // 7. 重复以上步骤，直到cur指向null
        ListNode prev = null;
        ListNode cur = slow;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = prev;
            prev = cur;
            cur = next;
        }
        slow = prev;// 反转后的链表头节点
        fast = head;// 原始链表头节点
        while (slow != null) {// 反转后的链表头节点不为空
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}