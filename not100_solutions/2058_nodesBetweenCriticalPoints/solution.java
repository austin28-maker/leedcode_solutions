/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = 0;
        int pre = Integer.MIN_VALUE / 2;
        int minDis = Integer.MAX_VALUE;
        ListNode a = head;
        ListNode b = head.next;
        ListNode c = head.next.next;

        for (int i = 1; c != null; i++) {
            if (a.val < b.val && b.val > c.val || a.val > b.val && b.val < c.val) {
                if (first == 0) {
                    first = i;
                }
                minDis = Math.min(minDis, i - pre);
                pre = i;
            }
            a = b;
            b = c;
            c = c.next;
        }

        if (first >= pre) { // 临界点少于两个
            return new int[]{-1, -1};
        }
        return new int[]{minDis, pre - first};
    }
}