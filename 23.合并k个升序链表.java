import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        ListNode dummy = new ListNode(-1), p = dummy;
        // 优先队列，最小堆。 构造函数（长度，判断方法）
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }
        while (!pq.isEmpty()) {
            // 弹出最小值
            ListNode temp = pq.poll();
            p.next = temp;
            // 将下一个ListNode 加进来比较
            if (temp.next != null) {
                pq.add(temp.next);
            }
            // ListNode 往下走
            p = p.next;
        }
        // 去头
        return dummy.next;
    }
}
// @lc code=end
