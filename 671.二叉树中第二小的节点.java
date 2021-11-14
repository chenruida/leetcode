/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int min = Integer.MAX_VALUE;
    int second = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return second;
        if (root.val >= max) {
            max = root.val;
        }
        if (root.val >= second && root.val < max) {
            second = root.val;
        }
        findSecondMinimumValue(root.left);
        findSecondMinimumValue(root.right);
        return second;
    }
}
// @lc code=end
