import java.util.List;

/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null)
            return null;
        // 初始化队列，将 root 加入队列
        Deque<TreeNode> que = new LinkedList<>();
        que.offerLast(root);

        while (!que.isEmpty()) {
            TreeNode peek = que.peekFirst();

            /* 层级遍历代码位置 */
            int levelSize = que.size();
            double levelSum = 0.0;
            /*****************/
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = que.pollFirst();
                levelSum += poll.val;
                if (poll.left != null) {
                    que.addLast(poll.left);
                }
                if (poll.right != null) {
                    que.addLast(poll.right);
                }
            }
            list.add(levelSum / levelSize);
        }
        return list;
    }
}
// @lc code=end
