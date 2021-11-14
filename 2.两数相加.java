/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(-1), p = temp;
        while (l1 != null) {
            p.next = l1;
            p.next.val = (l1.val + l2.val) % 10;
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }
        return temp.next;
    }
}
// @lc code=end
