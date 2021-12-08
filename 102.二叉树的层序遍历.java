import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    List<List<Integer>> resList = new ArrayList();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                TreeNode cur = q.poll();
                temp.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            resList.add(temp);
        }
        return resList;
    }
}
// @lc code=end
