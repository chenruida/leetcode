/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头节点,防止数组越界
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 找到倒数第N个节点
        ListNode temp = findFromEnd(dummy, n + 1);
        temp.next = temp.next.next;
        return dummy.next;

    }

    private ListNode findFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }
}
// @lc code=end
