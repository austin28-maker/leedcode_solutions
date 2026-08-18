/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ListNode;

// 方法一：优先队列合并
class Solution {
   public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            // 现场创建比较器对象

            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll(); // .poll() 是一个方法操作，用于从队列中删除并返回头元素
            p = p.next;
            if (p.next != null) queue.add(p.next);
        }
        return dummy.next;
    }
}

// 方法二：分治合并
// class Solution {
//    public ListNode mergeKLists(ListNode[] lists) {
//         if (lists == null || lists.length == 0) return null;
//         return merge(lists, 0, lists.length - 1);
//     }

//     // 修饰符用private，因为merge方法只在mergeKLists方法中调用，不被外部调用，所以用private可以隐藏merge方法
//     private ListNode merge(ListNode[] lists, int left, int right) {
//         if (left == right) return lists[left];
//         int mid = left + (right - left) / 2; // 防止溢出，注意是right - left
//         ListNode l1 = merge(lists, left, mid);
//         ListNode l2 = merge(lists, mid + 1, right);
//         return mergeTwoLists(l1, l2);
//     }

//     // 修饰符用private，因为mergeTwoLists方法只在mergeKLists方法中调用，不被外部调用，所以用private可以隐藏mergeTwoLists方法
//     private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         if (l1 == null) return l2;
//         if (l2 == null) return l1;
//         if (l1.val < l2.val) {
//             l1.next = mergeTwoLists(l1.next, l2);
//             return l1;
//         } else {
//             l2.next = mergeTwoLists(l1,l2.next);
//             return l2;
//         }
//     }
// }
