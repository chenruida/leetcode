import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    List<List<Integer>> resList = new LinkedList();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            LinkedList<Integer> item = new LinkedList<Integer>();
            resList.add(item);
        }
        if (deep % 2 == 0) {
            resList.get(deep - 1).add(node.val);
        } else {
            resList.get(deep - 1).add(0, node.val);
        }
        checkFun01(node.right, deep);
        checkFun01(node.left, deep);
    }
}
// @lc code=end
