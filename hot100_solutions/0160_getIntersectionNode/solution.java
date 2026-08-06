/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.List;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = pA == null ? headB : pA.next;// 该语句的语法结构是：条件 ? 表达式1 : 表达式2
            // 如果pA为空，就将pA指向headB，否则将pA指向pA的下一个节点
            // 设定该语句的目的是为了使pA和pB在遍历链表时，能够同时到达交点
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}