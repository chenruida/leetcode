import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
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
    List<Integer> resList = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        checkFun01(root, 0);
        return resList;
    }

    //DFS--递归方式
    public void checkFun01(TreeNode node, Integer deep) {
        if (node == null)
            return;
        // 增加一层
        deep++;

        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            resList.add(node.val);
        } else {
            resList.set(deep - 1, node.val);
        }
        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }
}
// @lc code=end
