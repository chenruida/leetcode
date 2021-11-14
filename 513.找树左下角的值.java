import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
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
    LinkedList<Integer> resList = new LinkedList<Integer>();

    public int findBottomLeftValue(TreeNode root) {
        checkFun01(root, 0);
        return resList.removeLast();
    }

    //DFS--递归方式
    public void checkFun01(TreeNode node, Integer deep) {
        if (node == null)
            return;
        // 增加一层
        deep++;

        if (resList.size() < deep) {
            resList.add(node.val);
        }
        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }
}
// @lc code=end
